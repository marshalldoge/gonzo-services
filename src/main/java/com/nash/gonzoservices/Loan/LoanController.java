package com.nash.gonzoservices.Loan;

import com.nash.gonzoservices.LoanVideo.LoanVideo;
import com.nash.gonzoservices.LoanVideo.LoanVideoRepository;
import com.nash.gonzoservices.ObjectResponse.ObjectResponse;
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

    @PostMapping
    public ObjectResponse createLoan(@RequestBody LoanRequest loanRequest) {
        System.out.println("Creating new Loan for user: "+loanRequest.getUserId());
        ObjectResponse res = new ObjectResponse();
        try{
            //Create a loan
            Loan loan =  new Loan();
            loan.setClientId(loanRequest.getClientId());
            loan.setCreation_time(LocalDateTime.now());
            loan.setNit(loanRequest.getNit());
            loan.setCost(loanRequest.getCost());
            loan.setDiscountId(Long.valueOf(1));
            loan.setUserId(loanRequest.getUserId());
            loan.setExpiration_time(loanRequest.getExpirationTime());
            loanRepository.save(loan);

            //Create loan_video
            ArrayList<MovieQuantity> moviesQuantity = loanRequest.getMovieQuantities();
            for(int i = 0; i < moviesQuantity.size(); i++) {
                for(int j = 0; j < moviesQuantity.get(i).getQuantity(); j++) {
                    LoanVideo loanVideo = new LoanVideo();
                    loanVideo.setLoan_id(loan.getId());
                    loanVideo.setVideo_id(moviesQuantity.get(i).getMovie_id());
                    //Set the video to unavailable
                    Video video = videoRepository.findById(moviesQuantity.get(i).getMovie_id()).get();
                    video.setAvailable(false);
                }
            }

        }catch (Exception e){
            res.setSuccess(false);
            res.setStatusMessage(e.getMessage());
        }finally {
            return res;
        }

    }
}
