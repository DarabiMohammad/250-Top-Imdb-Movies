package com.mohammad.data.repository;

import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.data.model.GenresEntity;
import com.mohammad.data.model.MovieEntity;
import com.mohammad.data.model.UserMovieEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public interface MoviesDataStore {

    Completable saveMovies(List<MovieEntity> mMovies);

    Completable saveDetailedMovie(DetailedMovieEntity mDetailedMovieEntity);

    Completable saveGenresList(List<GenresEntity> mGenresList);

    Completable saveSpecialGenreMovies(List<MovieEntity> mSpecialGenreMovies,int mGenreId);

    Completable clearMovies();

    Observable<List<MovieEntity>> getAllMovies(int mPageNumber);

    Observable<List<MovieEntity>> getMoviesByName(@NonNull String mName, int mPageNumber);

    Observable<DetailedMovieEntity> getMovieDetail(int mMovieId);

    Observable<List<GenresEntity>> getGenres();

    Observable<List<MovieEntity>> getSpecialGenreMovies(int mGenreId, int mPageNumber);

    Completable registerMovie(UserMovieEntity mMoview);
}
