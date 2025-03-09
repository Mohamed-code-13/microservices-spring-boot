package com.example.trendingservice.resources;

import com.example.grpc.Movie;
import com.example.grpc.TrendingRequest;
import com.example.grpc.TrendingResponse;
import com.example.grpc.TrendingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class TrendingResource extends TrendingServiceGrpc.TrendingServiceImplBase {

    @Override
    public void getTrendingMovies(TrendingRequest request, StreamObserver<TrendingResponse> responseObserver) {
        List<Movie> movies = List.of(
                Movie.newBuilder()
                        .setName("Movie 1")
                        .setDescription("Description 1")
                        .setRating(4.4f)
                        .build(),
                Movie.newBuilder()
                        .setName("Movie 2")
                        .setDescription("Description 2")
                        .setRating(2.2f)
                        .build(),
                Movie.newBuilder()
                        .setName("Movie 3")
                        .setDescription("Description 3")
                        .setRating(5.0f)
                        .build(),
                Movie.newBuilder()
                        .setName("Movie 4")
                        .setDescription("Description 4")
                        .setRating(1.4f)
                        .build(),
                Movie.newBuilder()
                        .setName("Movie 5")
                        .setDescription("Description 5")
                        .setRating(0.4f)
                        .build(),
                Movie.newBuilder()
                        .setName("Movie 6")
                        .setDescription("Description 6")
                        .setRating(0.0f)
                        .build()
        );

        TrendingResponse response = TrendingResponse.newBuilder()
                .addAllMovies(movies)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
