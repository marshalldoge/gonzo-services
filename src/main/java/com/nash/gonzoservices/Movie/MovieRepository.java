package com.nash.gonzoservices.Movie;

import com.nash.gonzoservices.LoanVideo.LoanVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}