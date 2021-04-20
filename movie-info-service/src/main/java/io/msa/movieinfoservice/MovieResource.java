package io.msa.movieinfoservice;

import io.msa.movieinfoservice.model.Movie;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{moiveId}")
    public Movie getMovieInfo(@PathVariable("moiveId") String movieId) {
        return new Movie(movieId, "Test name");
    }
}
