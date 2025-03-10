package com.example.movieinfoservice.service;

import com.example.grpc.Movie;
import com.example.grpc.MovieIds;
import com.example.grpc.MoviesInfoServiceGrpc;
import com.example.grpc.TrendingResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class TopMovieInfoService extends MoviesInfoServiceGrpc.MoviesInfoServiceImplBase {

    private GetMovieInfoService movieInfoService;

    public TopMovieInfoService(GetMovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @Override
    public void getMoviesInfo(MovieIds request,
                              StreamObserver<TrendingResponse> responseObserver) {
        List<Movie> movies = new ArrayList<>();

        for (String id : request.getIdList()) {
            var cur = movieInfoService.getMovieInfo(id);
            movies.add(Movie.newBuilder()
                    .setName(cur.getName())
                    .setDescription(cur.getDescription())
                    .setMovieId(cur.getMovieId())
                    .build());
        }

        TrendingResponse response = TrendingResponse.newBuilder()
                .addAllMovies(movies)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
