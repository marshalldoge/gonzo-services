package com.nash.gonzoservices.Video;

import com.nash.gonzoservices.LoanVideo.LoanVideo;
import com.nash.gonzoservices.Title.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByAvailable(Boolean available);
    List<Video> findAllByMovieIdAndAvailable(Long movieId, Boolean available);
}
