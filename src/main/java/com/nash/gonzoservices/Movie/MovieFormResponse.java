package com.nash.gonzoservices.Movie;

import java.util.ArrayList;

public class MovieFormResponse {
    ArrayList<ParsedMovie> movies;

    public ArrayList<ParsedMovie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<ParsedMovie> movies) {
        this.movies = movies;
    }
}
