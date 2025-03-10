package com.example.movieinfoservice.service;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import com.example.movieinfoservice.resources.MovieCacheRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetMovieInfoService {

    @Value("${api.key}")
    private String apiKey;

    private MovieCacheRepository cache;
    private RestTemplate restTemplate;

    public GetMovieInfoService(MovieCacheRepository movieCacheRepository, RestTemplate restTemplate) {
        this.cache = movieCacheRepository;
        this.restTemplate = restTemplate;
    }

    public Movie getMovieInfo(String movieId) {
        // Check MongoDB first for a cached result
        return cache.findById(movieId).orElseGet(() -> {
            System.out.println("fetching result from TMDB ID = " + movieId);
            // If result is not present in cache, get the movie info from TMDB
            final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
            MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);
            // Cache the result
            Movie movie = new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
            cache.insert(movie);
            return movie;
        });
    }
}
