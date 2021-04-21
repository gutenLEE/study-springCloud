package io.msa.moviecatalogservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rating {

    private String movieId;
    private int rating;

/*    public Rating() {
    }*/

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
}
