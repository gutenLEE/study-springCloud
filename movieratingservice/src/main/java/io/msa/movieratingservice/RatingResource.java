package io.msa.movieratingservice;

import io.msa.movieratingservice.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{moiveId]")
    public Rating getRating(@PathVariable("moiveId") String movieId) {
        return new Rating(movieId, 4);
    }
}
