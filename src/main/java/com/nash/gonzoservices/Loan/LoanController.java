package com.nash.gonzoservices.Loan;

import com.nash.gonzoservices.LoanVideo.LoanVideo;
import com.nash.gonzoservices.LoanVideo.LoanVideoRepository;
import com.nash.gonzoservices.ObjectResponse.ObjectResponse;
import com.nash.gonzoservices.Price.Price;
import com.nash.gonzoservices.Price.PriceRepository;
import com.nash.gonzoservices.Video.Video;
import com.nash.gonzoservices.Video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanVideoRepository loanVideoRepository;

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    PriceRepository priceRepository;

    @PostMapping
    public ObjectResponse createLoan(@RequestBody LoanRequest loanRequest) {
        System.out.println("Creating new Loan for user: "+loanRequest.getUserId());
        ObjectResponse res = new ObjectResponse();
        try{
            LoanResponse loanResponse = new LoanResponse();
            ArrayList<VideoDetails> videosToBeLoaned = new ArrayList<>();
            //Create a loan
            ArrayList<MovieQuantity> moviesQuantity = loanRequest.getMovieQuantities();
            Loan loan =  new Loan();
            loan.setClientId(loanRequest.getClientId());
            loan.setCreation_time(LocalDateTime.now());
            loan.setNit(loanRequest.getNit());
            loan.setCost(loanRequest.getCost());

            //Verify Cost
            ArrayList<Price> prices = (ArrayList)priceRepository.findAll();
            Double cost = 0.0;
            for(int i = 0; i < prices.size(); i++) {
                if(loanRequest.getDays() == prices.get(i).getDay()) {
                    cost = prices.get(i).getPrice();
                }
            }
            Double sum = 0.0;
            for(int i = 0; i < moviesQuantity.size(); i++) {
                sum += moviesQuantity.get(i).getUsed();
            }

            Double oficialPrice =  sum * cost;

            System.out.println("Cost given: " + loanRequest.getCost() +" vs Price Calculated: "+oficialPrice);
            if(Math.abs(oficialPrice - loanRequest.getCost()) > 0.03 ) {

                System.out.println("The cost is wrong!");
            }

            loan.setDiscountId(Long.valueOf(1));
            loan.setUserId(loanRequest.getUserId());
            loan.setExpiration_time(loanRequest.getExpirationTime());
            loanRepository.save(loan);

            //Create loan_video
            for(int i = 0; i < moviesQuantity.size(); i++) {
                for(int j = 0; j < moviesQuantity.get(i).getUsed(); j++) {
                    //First get the video
                    ArrayList<Video> videos = (ArrayList<Video>) videoRepository.findAllByMovieIdAndAvailable(moviesQuantity.get(i).getId(),true);
                    Long videoId = videos.get(0).getId();

                    LoanVideo loanVideo = new LoanVideo();
                    loanVideo.setLoan_id(loan.getId());
                    loanVideo.setVideo_id(videoId);
                    //Set the video to unavailable
                    Video video = videoRepository.findById(videoId).get();
                    VideoDetails videoDetails = new VideoDetails();
                    videoDetails.setId(videoId);
                    videoDetails.setMovieName(moviesQuantity.get(i).getName());
                    videosToBeLoaned.add(videoDetails);
                    video.setAvailable(false);
                    videoRepository.save(video);
                }
            }
            loanResponse.setVideos(videosToBeLoaned);
            res.setData(loanResponse);
        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }

    }
}
