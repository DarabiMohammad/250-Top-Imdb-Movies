package com.mohammad.remote.service;

import com.mohammad.remote.model.MainMoviesResponseModel;
import com.mohammad.remote.model.common.DetailedMovieModel;
import com.mohammad.remote.model.common.GenreModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApiMethods {

    @GET("movies")
    Observable<MainMoviesResponseModel> getAllMovies(@Query("page") int mPageNumber);

    @GET("movies")
    Observable<MainMoviesResponseModel> getMoviesByName(@Query("q") String mMovieName, @Query("page") int mPageNumber);

    @GET("movies")
    Observable<MainMoviesResponseModel> getMoviesByName(@Query("q") String mMovieName);

    @GET("movies/{movie_id}")
    Observable<DetailedMovieModel> getDatiledMovie(@Path("movie_id") int mMovieId);

    @GET("genres")
    Observable<List<GenreModel>> getGenres();

    @GET("genres/{genre_id}/movies")
    Observable<MainMoviesResponseModel> getSpecialGenreMovies(@Path("genre_id") int mGenreId, @Query("page") int mPageNumer);

    @GET("genres/{genre_id}/movies")
    Observable<MainMoviesResponseModel> getSpecialGenreMovies(@Path("genre_id") int mGenreId);

    //TODO post method for sending user movies to server
}
