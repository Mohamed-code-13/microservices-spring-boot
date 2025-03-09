package com.example.ratingsservice.models;

public class MovieRating {

    private int movieId;
    private double avgRate;

    public MovieRating() {}

    public MovieRating(int movieId, double avgRate) {
        this.movieId = movieId;
        this.avgRate = avgRate;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }
}
