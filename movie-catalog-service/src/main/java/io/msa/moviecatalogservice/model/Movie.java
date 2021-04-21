package io.msa.moviecatalogservice.model;

import lombok.Data;

@Data
public class Movie {

    private String movieId;
    private String name;

    public Movie() { } // when unmarshalling something which is not an obj to an object, we need to make a empty constructor. why?

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }
}
