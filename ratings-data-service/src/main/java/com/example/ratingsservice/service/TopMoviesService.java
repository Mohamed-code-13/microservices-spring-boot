package com.example.ratingsservice.service;


import com.example.grpc.MovieIds;
import com.example.grpc.TopMoviesServiceGrpc;
import com.google.protobuf.Empty;
import com.example.ratingsservice.repositories.RatingRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class TopMoviesService extends TopMoviesServiceGrpc.TopMoviesServiceImplBase {

    private final RatingRepository ratingRepository;

    public TopMoviesService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void getTopMovieIds(Empty request, StreamObserver<MovieIds> responseObserver) {
        List<String> ratingList = ratingRepository.getTopMovieIds();
        MovieIds topMovies = MovieIds.newBuilder()
                .addAllId(ratingList)
                .build();

        responseObserver.onNext(topMovies);
        responseObserver.onCompleted();
    }
}
