package com.example.trendingservice.resources;

import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import com.google.protobuf.Empty;

@GrpcService
public class TrendingResource extends TrendingMoviesServiceGrpc.TrendingMoviesServiceImplBase {

    @GrpcClient("rating-data-service")
    private TopMoviesServiceGrpc.TopMoviesServiceBlockingStub trendingServiceStub;

    @GrpcClient("movie-info-service")
    private MoviesInfoServiceGrpc.MoviesInfoServiceBlockingStub moviesInfoServiceStub;

    @Override
    public void getTrendingMovies(Empty request, StreamObserver<TrendingResponse> responseObserver) {
        Empty trendingRequest = Empty.getDefaultInstance();

        MovieIds movieIds = trendingServiceStub.getTopMovieIds(trendingRequest);

        TrendingResponse response = moviesInfoServiceStub.getMoviesInfo(movieIds);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
