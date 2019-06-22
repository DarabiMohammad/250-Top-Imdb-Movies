package com.mohammad.data.store;

import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.data.model.GenresEntity;
import com.mohammad.data.model.MovieEntity;
import com.mohammad.data.model.UserMovieEntity;
import com.mohammad.data.repository.MoviesCache;
import com.mohammad.data.repository.MoviesDataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class MoviesCacheImpl implements MoviesDataStore {

    private MoviesCache mCache;

    @Inject
    MoviesCacheImpl(MoviesCache mCache){
        this.mCache = mCache;
    }

    @Override
    public Completable saveMovies(List<MovieEntity> mMovies) {
        return mCache.saveMoviesToCache(mMovies)
                .andThen(mCache.setLastCacheTime(System.currentTimeMillis()));
    }

    @Override
    public Completable saveDetailedMovie(DetailedMovieEntity mDetailedMovieEntity) {
        return mCache.saveDetailedMovieToCache(mDetailedMovieEntity);
    }

    @Override
    public Completable saveGenresList(List<GenresEntity> mGenresList) {
        return mCache.saveGenresListToCache(mGenresList);
    }

    @Override
    public Completable saveSpecialGenreMovies(List<MovieEntity> mSpecialGenreMovies, int mGenreId) {
        return mCache.saveSpecialGenreMoviesToCache(mSpecialGenreMovies,mGenreId);
    }

    @Override
    public Completable clearMovies() {
        return mCache.clearMoviesFromCache();
    }

    @Override
    public Observable<List<MovieEntity>> getAllMovies(int mPageNumber) {
        return mCache.getMoviesFromCache();
    }

    @Override
    public Observable<List<MovieEntity>> getMoviesByName(String mName, int mPageNumber) {
        return mCache.getMoviesByNameFromCache(mName);
    }

    @Override
    public Observable<DetailedMovieEntity> getMovieDetail(int mMovieId) {
        return mCache.getDetailedMovieFromCache(mMovieId);
    }

    @Override
    public Observable<List<GenresEntity>> getGenres() {
        return mCache.getGenresFromCache();
    }

    @Override
    public Observable<List<MovieEntity>> getSpecialGenreMovies(int mGenreId, int mPageNumber) {
        return mCache.getSpecialGenreMoviesFromCache(mGenreId);
    }

    @Override
    public Completable registerMovie(UserMovieEntity mMoview) {
        return mCache.registerMovieToCache(mMoview);
    }
}
