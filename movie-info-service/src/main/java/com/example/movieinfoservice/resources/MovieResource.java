package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.service.GetMovieInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    private GetMovieInfoService movieInfoService;

    public MovieResource(GetMovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return movieInfoService.getMovieInfo(movieId);
    }
}


