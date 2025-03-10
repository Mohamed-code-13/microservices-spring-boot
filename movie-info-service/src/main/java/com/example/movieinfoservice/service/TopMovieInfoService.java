package com.example.movieinfoservice.service;

import com.example.grpc.Movie;
import com.example.grpc.MovieIds;
import com.example.grpc.MoviesInfoServiceGrpc;
import com.example.grpc.TrendingResponse;
import com.example.movieinfoservice.resources.MovieCacheRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class TopMovieInfoService extends MoviesInfoServiceGrpc.MoviesInfoServiceImplBase {

    private MovieCacheRepository movieCacheRepository;

    public TopMovieInfoService(MovieCacheRepository movieCacheRepository) {
        this.movieCacheRepository = movieCacheRepository;
    }

    @Override
    public void getMoviesInfo(MovieIds request,
                              StreamObserver<TrendingResponse> responseObserver) {
        List<Movie> movies = new ArrayList<>();

        for (int id : request.getIdList()) {
            movieCacheRepository.
        }

    }

}
