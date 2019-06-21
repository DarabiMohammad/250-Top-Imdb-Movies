package com.mohammad.remote;

import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.data.model.GenresEntity;
import com.mohammad.data.model.MovieEntity;
import com.mohammad.data.model.UserMovieEntity;
import com.mohammad.data.repository.MoviesRemote;
import com.mohammad.remote.mapper.DetailedMovieResponseMapper;
import com.mohammad.remote.mapper.GenresResponseMapper;
import com.mohammad.remote.mapper.MoviesResponseMapper;
import com.mohammad.remote.model.common.GenreModel;
import com.mohammad.remote.model.common.MovieModel;
import com.mohammad.remote.service.MoviesApiMethods;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class MoviesRemoteImp implements MoviesRemote {

    private MoviesApiMethods mService;
    private MoviesResponseMapper mMoviesMapper;
    private DetailedMovieResponseMapper mDetailedMoviesMapper;
    private GenresResponseMapper mGenresMapper;

    @Inject
    public MoviesRemoteImp(MoviesApiMethods mService,
                           MoviesResponseMapper mMoviesMapper,
                           DetailedMovieResponseMapper mDetailedMoviesMapper,
                           GenresResponseMapper mGenresMapper) {
        this.mService = mService;
        this.mMoviesMapper = mMoviesMapper;
        this.mDetailedMoviesMapper = mDetailedMoviesMapper;
        this.mGenresMapper = mGenresMapper;
    }

    @Override
    public Observable<List<MovieEntity>> getAllMovies(int mPageNumber) {
        return mService.getAllMovies(mPageNumber).map(mMainMoviesResponseModel -> {
            List<MovieEntity> mMovieEntities = new ArrayList<>();
            for (MovieModel mModel : mMainMoviesResponseModel.getMovies()) {
                mMovieEntities.add(mMoviesMapper.mapFromModel(mModel));
            }
            return mMovieEntities;
        });
    }

    @Override
    public Observable<List<MovieEntity>> getMoviesByName(String mName, int mPageNumber) {
        return mService.getMoviesByName(mName, mPageNumber).map(mMainMoviesResponseModel -> {
            List<MovieEntity> mMovieEntities = new ArrayList<>();
            for (MovieModel mModel : mMainMoviesResponseModel.getMovies()) {
                mMovieEntities.add(mMoviesMapper.mapFromModel(mModel));
            }
            return mMovieEntities;
        });
    }

    @Override
    public Observable<List<MovieEntity>> getMoviesByName(String mName) {
        return mService.getMoviesByName(mName).map(mMainMoviesResponseModel -> {
            List<MovieEntity> mMovieEntities = new ArrayList<>();
            for (MovieModel mModel : mMainMoviesResponseModel.getMovies()) {
                mMovieEntities.add(mMoviesMapper.mapFromModel(mModel));
            }
            return mMovieEntities;
        });
    }

    @Override
    public Observable<DetailedMovieEntity> getMovieDetail(int mMovieId) {
        return mService.getDatiledMovie(mMovieId).map(mDetailedMovieModel ->
                mDetailedMoviesMapper.mapFromModel(mDetailedMovieModel));
    }

    @Override
    public Observable<List<GenresEntity>> getGenres() {
        return mService.getGenres().map(mGenreModels -> {
            List<GenresEntity> mGenresEntity = new ArrayList<>();
            for (GenreModel mModel : mGenreModels) {
                mGenresEntity.add(mGenresMapper.mapFromModel(mModel));
            }
            return mGenresEntity;
        });
    }

    @Override
    public Observable<List<MovieEntity>> getSpecialGenreMovies(int mGenreId, int mPageNumber) {
        return mService.getSpecialGenreMovies(mGenreId, mPageNumber).map(mMainMoviesResponseModel -> {
            List<MovieEntity> mMoviesEntity = new ArrayList<>();
            for (MovieModel mModel : mMainMoviesResponseModel.getMovies()) {
                mMoviesEntity.add(mMoviesMapper.mapFromModel(mModel));
            }
            return mMoviesEntity;
        });
    }

    @Override
    public Observable<List<MovieEntity>> getSpecialGenreMovies(int mGenreId) {
        return mService.getSpecialGenreMovies(mGenreId).map(mMainMoviesResponseModel -> {
            List<MovieEntity> mMoviesEntity = new ArrayList<>();
            for (MovieModel mModel : mMainMoviesResponseModel.getMovies()) {
                mMoviesEntity.add(mMoviesMapper.mapFromModel(mModel));
            }
            return mMoviesEntity;
        });
    }

    @Override
    public Completable registerMovie(UserMovieEntity mMoview) {
        return null;
    }
}
