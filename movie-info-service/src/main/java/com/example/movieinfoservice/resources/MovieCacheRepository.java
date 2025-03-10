package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieCacheRepository extends MongoRepository<Movie, String> {
}
