package com.mohammad.data.repository;

import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.data.model.GenresEntity;
import com.mohammad.data.model.MovieEntity;
import com.mohammad.data.model.UserMovieEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public interface MoviesCache {

    Completable clearMoviesFromCache();

    Completable saveMoviesToCache(List<MovieEntity> mEntityMovies);

    Completable saveDetailedMovie(DetailedMovieEntity mDetailedMovieEntity);

    Completable saveGenresList(List<GenresEntity> mGenresList);

    Completable saveSpecialGenreMovies(List<MovieEntity> mSpecialGenreMovies);

    Observable<List<MovieEntity>> getMovies();

    Observable<List<MovieEntity>> getMoviesByName(@NonNull String mName, @Nullable int mPageNumber);

    Observable<DetailedMovieEntity> getMovieDetail(@NonNull int mMovieId);

    Observable<List<GenresEntity>> getGenres();

    Observable<List<MovieEntity>> getSpecialGenreMovies(@NonNull int mGenreId, @Nullable int mPageNumber);

    Completable registerMovie(UserMovieEntity mMoview);

    Single<Boolean> areMoviesCached();

    Completable setLastCacheTime(long mLastTime);

    Single<Boolean> isCacheExpired() ;
}
