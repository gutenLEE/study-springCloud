package io.msa.moviecatalogservice;

import io.msa.moviecatalogservice.model.CatalogItem;
import io.msa.moviecatalogservice.model.Movie;
import io.msa.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //RestTemplate restTemplate = new RestTemplate(); // every call, a new resTemplate created...bad

        // get all rated movie IDs
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("4567", 5)
        );

        return ratings.stream().map(rating -> {
            // For each movie ID, call movie-info-service API and get details
            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            // hard-coding url is bad.

            return new CatalogItem(movie.getName(), "Test", rating.getRating());
        }).collect(Collectors.toList());


        // put them all together

        /* return Collections.singletonList(
                new CatalogItem("Transformers", "SF", 4)
        );*/
    }
}
