package io.msa.movieratingservice;

import io.msa.movieratingservice.model.Rating;
import io.msa.movieratingservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{moiveId}")
    public Rating getRating(@PathVariable("moiveId") String movieId) {
        return new Rating(movieId, 4);
    }

    // do another API which takes in a user ID and then returns a list of movies that user has rated
    @RequestMapping("users/{userId}") // API endpoint
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings =  Arrays.asList(
                new Rating("100", 4),
                new Rating("200", 5)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;

        // don't recommend doing this way
        // why?
        /*
            what's the route known afters JSON that you are gointg to get back
            it's a list. it's not an object.

            what's the problem with having any API return a list as the root node?
            deserialization is a little bit of a challenge!
         */
    }
}
