package com.mohammad.domain.repository;

import com.mohammad.domain.model.MovieModel;
import com.mohammad.domain.model.DetailedMovieModel;
import com.mohammad.domain.model.GenresModel;
import com.mohammad.domain.model.UserMovieModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public interface MoviesRepository {

    Observable<List<MovieModel>> getAllMovies();

    Observable<List<MovieModel>> getMoviesByName(@NonNull String mName, @Nullable int mPageNumber);

    Observable<DetailedMovieModel> getMovieDetail(@NonNull int mMovieId);

    Observable<List<GenresModel>> getGenres();

    Observable<List<MovieModel>> getSpecialGenreMovies(@NonNull int mGenreId, @Nullable int mPageNumber);

    Completable registerMovie(UserMovieModel mMoview);
}
