package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;
    @Autowired
    private MovieCacheRepository cache;

    public MovieResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        // ------------------- Cache implementation -------------------
        // Check MongoDB first for a cached result
        return getCachedMovie(movieId).orElseGet(() -> {
            // If result is not present in cache, get the movie info from TMDB
            Movie movie = getRemoteMovie(movieId);
            // Cache the result
            cache.insert(movie);
            return movie;
        });
        // ----------------- No-cache implementation -----------------
//        return getRemoteMovie(movieId);
    }

    private Optional<Movie> getCachedMovie(String movieId) {
        return cache.findById(movieId);
    }

    private Movie getRemoteMovie(String movieId) {
        // Get the movie info from TMDB
        final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
        MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}


