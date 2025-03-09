package com.example.ratingsservice.repositories;

import com.example.ratingsservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(String userId);

    @Query(value = "SELECT movie_id " +
            "FROM ratings " +
            "GROUP BY movie_id " +
            "ORDER BY AVG(rating) DESC " +
            "LIMIT 10",
            nativeQuery = true)
    List<Integer> getTopMovieIds();
}