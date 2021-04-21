package io.msa.moviecatalogservice;


import io.msa.moviecatalogservice.model.CatalogItem;
import io.msa.moviecatalogservice.model.Movie;
import io.msa.moviecatalogservice.model.Rating;
import io.msa.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient discoveryClient;

/*    @Autowired
    private WebClient.Builder webClientBuilder;*/

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //RestTemplate restTemplate = new RestTemplate(); // every call, a new resTemplate created...bad

        //WebClient.Builder builder = WebClient.builder();

        // get all rated movie IDs

        UserRating ratings = restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class); //-> hard-coding url is bad.
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());

        }).collect(Collectors.toList());


        // put them all together

        /* return Collections.singletonList(
                new CatalogItem("Transformers", "SF", 4)
        );*/
    }
}

    /*
    Movie movie = webClientBuilder.build()
            .get()
            .uri("http://localhost:8081/movies/" + rating.getMovieId()) // go to url
            .retrieve() // fetch me the data
            .bodyToMono(Movie.class) // body you get back convert it into an instance of this movie class
            .block(); // it's the block you're blocking execution till that mono is fulfilled
    */

    /*
        what is mono?
        is kind of like a promise that this thing is eventually gonna get you what you want that's how you do a synchronous
        in the future going to give you what you want
     */