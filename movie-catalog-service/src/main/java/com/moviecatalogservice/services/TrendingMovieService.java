package com.moviecatalogservice.services;

import com.example.grpc.TrendingMoviesServiceGrpc;
import com.google.protobuf.Empty;
import com.moviecatalogservice.models.Movie;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrendingMovieService {

    @GrpcClient("trending-movies-service")
    private TrendingMoviesServiceGrpc.TrendingMoviesServiceBlockingStub trendingServiceGrpc;

    public List<Movie> GetTrendingMovies(){
        return trendingServiceGrpc.getTrendingMovies(Empty.getDefaultInstance())
                .getMoviesList().stream()
                .map(protoMovie ->  new Movie(
                        protoMovie.getMovieId(),
                        protoMovie.getName(),
                        protoMovie.getDescription()
                )).collect(Collectors.toList());
    }

}