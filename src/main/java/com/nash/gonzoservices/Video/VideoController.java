package com.nash.gonzoservices.Video;

import com.nash.gonzoservices.ObjectResponse.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/video")
public class VideoController {
    @Autowired
    VideoRepository videoRepository;


    @GetMapping
    public ObjectResponse getAvailabelVideos() {
        ObjectResponse res = new ObjectResponse();
        try {
            ArrayList<Video> videos = (ArrayList)videoRepository.findAllByAvailable(true);
            res.setData(videos);

        } catch (Exception e) {
            res.setStatusMessage(e.getMessage());
        } finally {
            return res;
        }
    }
}
