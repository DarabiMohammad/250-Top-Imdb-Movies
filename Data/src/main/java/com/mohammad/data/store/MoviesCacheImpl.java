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
        return mCache.saveDetailedMovie(mDetailedMovieEntity);
    }

    @Override
    public Completable saveGenresList(List<GenresEntity> mGenresList) {
        return mCache.saveGenresList(mGenresList);
    }

    @Override
    public Completable saveSpecialGenreMovies(List<MovieEntity> mSpecialGenreMovies) {
        return mCache.saveSpecialGenreMovies(mSpecialGenreMovies);
    }

    @Override
    public Completable clearMovies() {
        return mCache.clearMoviesFromCache();
    }

    @Override
    public Observable<List<MovieEntity>> getAllMovies() {
        return mCache.getMovies();
    }

    @Override
    public Observable<List<MovieEntity>> getMoviesByName(String mName, int mPageNumber) {
        return mCache.getMoviesByName(mName,mPageNumber);
    }

    @Override
    public Observable<DetailedMovieEntity> getMovieDetail(int mMovieId) {
        return mCache.getMovieDetail(mMovieId);
    }

    @Override
    public Observable<List<GenresEntity>> getGenres() {
        return mCache.getGenres();
    }

    @Override
    public Observable<List<MovieEntity>> getSpecialGenreMovies(int mGenreId, int mPageNumber) {
        return mCache.getSpecialGenreMovies(mGenreId,mPageNumber);
    }

    @Override
    public Completable registerMovie(UserMovieEntity mMoview) {
        return mCache.registerMovie(mMoview);
    }
}
