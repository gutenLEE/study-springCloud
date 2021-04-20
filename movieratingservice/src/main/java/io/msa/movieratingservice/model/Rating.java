package io.msa.movieratingservice.model;

import lombok.Data;

@Data
public class Rating {

    private String movieId;
    private int Rating;

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        Rating = rating;
    }
}
