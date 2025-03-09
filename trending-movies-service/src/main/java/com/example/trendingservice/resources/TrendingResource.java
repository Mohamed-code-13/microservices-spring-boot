package com.example.trendingservice.resources;

import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class TrendingResource extends TrendingMoviesServiceGrpc.TrendingMoviesServiceImplBase {

    @GrpcClient("rating-data-service")
    private TopMoviesServiceGrpc.TopMoviesServiceBlockingStub trendingServiceStub;

    @Override
    public void getTrendingMovies(TrendingRequest request, StreamObserver<TrendingResponse> responseObserver) {
        TrendingRequest trendingRequest = TrendingRequest.newBuilder().build();

        MovieIds movieIds = trendingServiceStub.getTopMovieIds(trendingRequest);


        System.out.println("Top Ids");
        for (int id : movieIds.getIdList())
            System.out.println(id);

    }

}
