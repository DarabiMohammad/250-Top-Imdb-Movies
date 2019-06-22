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

public interface MoviesCache {

    Completable clearMoviesFromCache();

    Completable saveMoviesToCache(@NonNull List<MovieEntity> mEntityMovies);

    Completable saveDetailedMovieToCache(@NonNull DetailedMovieEntity mDetailedMovieEntity);

    Completable saveGenresListToCache(@NonNull List<GenresEntity> mGenresList);

    Completable saveSpecialGenreMoviesToCache(@NonNull List<MovieEntity> mSpecialGenreMovies,@NonNull int mGenreId);

    Observable<List<MovieEntity>> getMoviesFromCache();

    Observable<List<MovieEntity>> getMoviesByNameFromCache(@NonNull String mName);

    Observable<DetailedMovieEntity> getDetailedMovieFromCache(@NonNull int mMovieId);

    Observable<List<GenresEntity>> getGenresFromCache();

    Observable<List<MovieEntity>> getSpecialGenreMoviesFromCache(@NonNull int mGenreId);

    Completable registerMovieToCache(@NonNull UserMovieEntity mMoview);

    Single<Boolean> areMoviesCached();

    Completable setLastCacheTime(@NonNull long mLastTime);

    Single<Boolean> isCacheExpired() ;
}
