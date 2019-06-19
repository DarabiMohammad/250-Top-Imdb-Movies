package com.mohammad.data.store;

import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.data.model.GenresEntity;
import com.mohammad.data.model.MovieEntity;
import com.mohammad.data.model.UserMovieEntity;
import com.mohammad.data.repository.MoviesDataStore;
import com.mohammad.data.repository.MoviesRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class MoviesRemoteImpl implements MoviesDataStore {

    private MoviesRemote mRemote;

    @Inject
    MoviesRemoteImpl() {
    }

    @Override
    public Completable saveMovies(List<MovieEntity> mMovies) {
        throw new UnsupportedOperationException("Saving Movies Isnt Supported Here . . . ");
    }

    @Override
    public Completable saveDetailedMovie(DetailedMovieEntity mDetailedMovieEntity) {
        throw new UnsupportedOperationException("Saving Detailed Movie Isnt Supported Here . . . ");
    }

    @Override
    public Completable saveGenresList(List<GenresEntity> mGenresList) {
        throw new UnsupportedOperationException("Saving Genres List Isnt Supported Here . . . ");
    }

    @Override
    public Completable saveSpecialGenreMovies(List<MovieEntity> mSpecialGenreMovies) {
        throw new UnsupportedOperationException("Saving Special Genre Movies Isnt Supported Here . . . ");
    }

    @Override
    public Completable clearMovies() {
        throw new UnsupportedOperationException(" Isnt Supported Here . . . ");
    }

    @Override
    public Observable<List<MovieEntity>> getAllMovies() {
        return mRemote.getAllMovies();
    }

    @Override
    public Observable<List<MovieEntity>> getMoviesByName(String mName, int mPageNumber) {
        throw new UnsupportedOperationException("Getting Movies By Name Isnt Supported Here . . . ");
    }

    @Override
    public Observable<DetailedMovieEntity> getMovieDetail(int mMovieId) {
        throw new UnsupportedOperationException("Getting Movie Details Isnt Supported Here . . . ");
    }

    @Override
    public Observable<List<GenresEntity>> getGenres() {
        throw new UnsupportedOperationException("Getting Genres Isnt Supported Here . . . ");
    }

    @Override
    public Observable<List<MovieEntity>> getSpecialGenreMovies(int mGenreId, int mPageNumber) {
        throw new UnsupportedOperationException("Getting Special Genre Movies Isnt Supported Here . . . ");
    }

    @Override
    public Completable registerMovie(UserMovieEntity mMoview) {
        throw new UnsupportedOperationException("Registering Movies Isnt Supported Here . . . ");
    }
}
