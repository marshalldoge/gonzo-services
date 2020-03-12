package com.nash.gonzoservices.Movie;

import com.nash.gonzoservices.ObjectResponse.ObjectResponse;
import com.nash.gonzoservices.Title.Title;
import com.nash.gonzoservices.Title.TitleRepository;
import com.nash.gonzoservices.Video.Video;
import com.nash.gonzoservices.Video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
    @Autowired
    VideoRepository videoRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TitleRepository titleRepository;

    @GetMapping
    public ObjectResponse getVideos() {
        ObjectResponse res = new ObjectResponse();
        try {

            MovieFormResponse movieFormResponse = new MovieFormResponse();

            ArrayList<ParsedMovie> parsedMovies = new ArrayList<>();

            ArrayList<Movie> movies = (ArrayList)movieRepository.findAll();


            ArrayList<Video> videos = (ArrayList)videoRepository.findAllByAvailable(true);
            res.setData(videos);

            ArrayList<Movie> title = (ArrayList)titleRepository.findAll();

            for( int i = 0; i < movies.size(); i++) {
                ArrayList<Title> titles = (ArrayList)titleRepository.findAllByMovieId(movies.get(i).getId());
                ArrayList<Video> videoQuantity = (ArrayList)videoRepository.findAllByMovieIdAndAvailable(movies.get(i).getId(),true);
                ParsedMovie parsedMovie = new ParsedMovie();
                parsedMovie.setId(movies.get(i).getId());
                parsedMovie.setName(titles.get(0).getName());
                parsedMovie.setDuration(movies.get(i).getDuration());
                parsedMovie.setQuantity(videoQuantity.size());
                parsedMovies.add(parsedMovie);
            }

            movieFormResponse.setMovies(parsedMovies);
            res.setData(movieFormResponse);

        } catch (Exception e) {
            res.setStatusMessage(e.getMessage());
        } finally {
            return res;
        }
    }
}
