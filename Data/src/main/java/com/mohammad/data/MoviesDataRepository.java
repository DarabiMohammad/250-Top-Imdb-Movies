package com.mohammad.data;

import com.mohammad.data.mapper.DetailedMovieMapper;
import com.mohammad.data.mapper.GenreMapper;
import com.mohammad.data.mapper.MovieMapper;
import com.mohammad.data.mapper.UserMovieMapper;
import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.data.model.GenresEntity;
import com.mohammad.data.model.MovieEntity;
import com.mohammad.data.repository.MoviesCache;
import com.mohammad.data.store.MoviesDataStoreFactory;
import com.mohammad.domain.model.DetailedMovieModel;
import com.mohammad.domain.model.GenresModel;
import com.mohammad.domain.model.MovieModel;
import com.mohammad.domain.model.UserMovieModel;
import com.mohammad.domain.repository.MoviesRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MoviesDataRepository implements MoviesRepository {

    private MovieMapper mMovieMapper;
    private DetailedMovieMapper mDetailedMovieMapper;
    private UserMovieMapper mUserMovieMapper;
    private GenreMapper mGenreMapper;
    private MoviesCache mMoviesCache;
    private MoviesDataStoreFactory mFactory;

    @Inject
    public MoviesDataRepository(MovieMapper mMovieMapper,
                                DetailedMovieMapper mDetailedMovieMapper,
                                UserMovieMapper mUserMovieMapper,
                                GenreMapper mGenreMapper,
                                MoviesCache mMoviesCache,
                                MoviesDataStoreFactory mFactory) {
        this.mMovieMapper = mMovieMapper;
        this.mDetailedMovieMapper = mDetailedMovieMapper;
        this.mUserMovieMapper = mUserMovieMapper;
        this.mGenreMapper = mGenreMapper;
        this.mMoviesCache = mMoviesCache;
        this.mFactory = mFactory;
    }

    private Observable<Boolean[]> setUpCacheVariablesObservable() {
        return Observable
                .zip(mMoviesCache.areMoviesCached().toObservable(),
                        mMoviesCache.isCacheExpired().toObservable(),
                        (mIsCached, mIsExpired) -> new Boolean[]{mIsCached, mIsExpired}
                );
    }

    @Override
    public Observable<List<MovieModel>> getAllMovies() {
        return setUpCacheVariablesObservable()
                .flatMap((Function<Boolean[], Observable<List<MovieEntity>>>) booleans ->
                        mFactory.getMoviesDataStore(booleans[0], booleans[1]).getAllMovies())
                .flatMap((Function<List<MovieEntity>, Observable<List<MovieEntity>>>) movieEntities ->
                        mFactory.getCacheMoviesDataStore().saveMovies(movieEntities)
                                .andThen(Observable.just(movieEntities)))
                .map(mMovieEntities -> {
                    List<MovieModel> mMovieModels = new ArrayList<>();
                    for (MovieEntity mMovieEntity : mMovieEntities) {
                        mMovieModels.add(mMovieMapper.mapFromEntity(mMovieEntity));
                    }
                    return mMovieModels;
                });
    }

    @Override
    public Observable<List<MovieModel>> getMoviesByName(String mName, int mPageNumber) {
        return setUpCacheVariablesObservable()
                .flatMap((Function<Boolean[], Observable<List<MovieEntity>>>) booleans ->
                        mFactory.getMoviesDataStore(booleans[0], booleans[1]).getMoviesByName(mName, mPageNumber))
                .flatMap((Function<List<MovieEntity>, Observable<List<MovieEntity>>>) movieEntities ->
                        mFactory.getCacheMoviesDataStore().saveMovies(movieEntities)
                                .andThen(Observable.just(movieEntities)))
                .map(mMovieEntities -> {
                    List<MovieModel> mMovieModels = new ArrayList<>();
                    for (MovieEntity mMovieEntity : mMovieEntities) {
                        mMovieModels.add(mMovieMapper.mapFromEntity(mMovieEntity));
                    }
                    return mMovieModels;
                });
    }

    @Override
    public Observable<DetailedMovieModel> getMovieDetail(int mMovieId) {
        return setUpCacheVariablesObservable()
                .flatMap((Function<Boolean[], Observable<DetailedMovieEntity>>) booleans ->
                        mFactory.getMoviesDataStore(booleans[0],booleans[1]).getMovieDetail(mMovieId))
                .flatMap((Function<DetailedMovieEntity, Observable<DetailedMovieEntity>>) mDetailedMovieEntity ->
                        mFactory.getCacheMoviesDataStore().saveDetailedMovie(mDetailedMovieEntity)
                        .andThen(Observable.just(mDetailedMovieEntity)))
                .map(mDetailedMovieEntity -> mDetailedMovieMapper.mapFromEntity(mDetailedMovieEntity));
    }

    @Override
    public Observable<List<GenresModel>> getGenres() {
        return setUpCacheVariablesObservable()
                .flatMap((Function<Boolean[], Observable<List<GenresEntity>>>) booleans ->
                        mFactory.getMoviesDataStore(booleans[0],booleans[1]).getGenres())
                .flatMap((Function<List<GenresEntity>, Observable<List<GenresEntity>>>) mGenresEntities -> mFactory.getCacheMoviesDataStore().saveGenresList(mGenresEntities)
                        .andThen(Observable.just(mGenresEntities)))
                .map(mGenresEntities -> {
                    List<GenresModel> mGenresList = new ArrayList<>();
                    for (GenresEntity mGenres : mGenresEntities){
                        mGenresList.add(mGenreMapper.mapFromEntity(mGenres));
                    }
                    return mGenresList;
                });
    }

    @Override
    public Observable<List<MovieModel>> getSpecialGenreMovies(int mGenreId, int mPageNumber) {
        return setUpCacheVariablesObservable()
                .flatMap((Function<Boolean[], Observable<List<MovieEntity>>>) booleans ->
                        mFactory.getMoviesDataStore(booleans[0],booleans[1]).getSpecialGenreMovies(mGenreId,mPageNumber))
                .flatMap((Function<List<MovieEntity>, Observable<List<MovieEntity>>>) mMovieEntities ->
                        mFactory.getCacheMoviesDataStore().saveSpecialGenreMovies(mMovieEntities)
                        .andThen(Observable.just(mMovieEntities)))
                .map(mMovieEntities -> {
                    List<MovieModel> mSpecialMovies = new ArrayList<>();
                    for (MovieEntity mMovieEntity : mMovieEntities){
                        mSpecialMovies.add(mMovieMapper.mapFromEntity(mMovieEntity));
                    }
                    return mSpecialMovies;
                });
    }

    @Override
    public Completable registerMovie(UserMovieModel mMoview) {
        return null;
    }
}
