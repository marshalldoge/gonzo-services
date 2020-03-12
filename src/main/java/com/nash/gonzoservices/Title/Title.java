package com.nash.gonzoservices.Title;

import javax.persistence.*;

@Entity
@Table(name = "\"title\"")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long movieId;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
