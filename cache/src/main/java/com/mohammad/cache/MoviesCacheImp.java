package com.mohammad.cache;

import android.content.Context;

import com.mohammad.cache.db.MoviesDataBase;
import com.mohammad.cache.mapper.DetailedMovieMapper;
import com.mohammad.cache.mapper.GenreMapper;
import com.mohammad.cache.mapper.MovieMapper;
import com.mohammad.cache.model.CachedDetailedMovie;
import com.mohammad.cache.model.CachedGenres;
import com.mohammad.cache.model.CachedMovie;
import com.mohammad.cache.model.Config;
import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.data.model.GenresEntity;
import com.mohammad.data.model.MovieEntity;
import com.mohammad.data.model.UserMovieEntity;
import com.mohammad.data.repository.MoviesCache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class MoviesCacheImp implements MoviesCache {

    private Context mContext;
    private MoviesDataBase mDataBase;
    private MovieMapper mMovieMapper;
    private DetailedMovieMapper mDetailedMovieMapper;
    private GenreMapper mGenreMapper;

    @Inject
    public MoviesCacheImp(Context mContext, MoviesDataBase mDataBase,
                          MovieMapper mMovieMapper,
                          DetailedMovieMapper mDetailedMovieMapper,
                          GenreMapper mGenreMapper) {
        this.mContext = mContext;
        this.mDataBase = mDataBase;
        this.mMovieMapper = mMovieMapper;
        this.mDetailedMovieMapper = mDetailedMovieMapper;
        this.mGenreMapper = mGenreMapper;
    }

    @Override
    public Completable clearMoviesFromCache() {
        return Completable.defer(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                mDataBase.getMoviesDao().clearAllMoviesFromCache();
                return Completable.complete();
            }
        });
    }

    @Override
    public Completable saveMoviesToCache(final List<MovieEntity> mEntityMovies) {
        return Completable.defer(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                List<CachedMovie> mCachedMovies = new ArrayList<>();
                for (MovieEntity mModel : mEntityMovies) {
                    mCachedMovies.add(mMovieMapper.mapToCache(mModel));
                }
                mDataBase.getMoviesDao().saveMoviesToCache(mCachedMovies);
                return Completable.complete();
            }
        });
    }

    @Override
    public Completable saveDetailedMovieToCache(final DetailedMovieEntity mDetailedMovieEntity) {
        return Completable.defer(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                mDataBase.getMoviesDao().saveDetailedMovieToCache(mDetailedMovieMapper.mapToCache(mDetailedMovieEntity));
                return Completable.complete();
            }
        });
    }

    @Override
    public Completable saveGenresListToCache(final List<GenresEntity> mGenresList) {
        return Completable.defer(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                List<CachedGenres> mCachedGenres = new ArrayList<>();
                for (GenresEntity mModel : mGenresList) {
                    mCachedGenres.add(mGenreMapper.mapToCache(mModel));
                }
                mDataBase.getMoviesDao().saveGenresToCache(mCachedGenres);
                return Completable.complete();
            }
        });
    }

    @Override
    public Completable saveSpecialGenreMoviesToCache(final List<MovieEntity> mSpecialGenreMovies, final int mGenreId) {
        return Completable.defer(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                List<CachedMovie> mCachedMovies = new ArrayList<>();
                int[] mMovieIds = new int[mSpecialGenreMovies.size()];
                for (int i = 0; i < mSpecialGenreMovies.size(); i++) {
                    mMovieIds[i] = mSpecialGenreMovies.get(i).getId();
                    mCachedMovies.add(mMovieMapper.mapToCache(mSpecialGenreMovies.get(i)));
                }
                mDataBase.getMoviesDao().updateSpecialGenreMovieIds(mMovieIds, mGenreId);
                mDataBase.getMoviesDao().saveMoviesToCache(mCachedMovies);
                return Completable.complete();
            }
        });
    }

    @Override
    public Observable<List<MovieEntity>> getMoviesFromCache() {
        return mDataBase.getMoviesDao().getAllMoviesFromCache().toObservable()
                .map(new Function<List<CachedMovie>, List<MovieEntity>>() {
                    @Override
                    public List<MovieEntity> apply(List<CachedMovie> mCachedMovies) throws Exception {
                        List<MovieEntity> mMovieEntities = new ArrayList<>();
                        for (CachedMovie mModel : mCachedMovies) {
                            mMovieEntities.add(mMovieMapper.mapFromCache(mModel));
                        }
                        return mMovieEntities;
                    }
                });
    }

    @Override
    public Observable<List<MovieEntity>> getMoviesByNameFromCache(String mName) {
        return mDataBase.getMoviesDao().getMoiveByNameFromCache(mName).toObservable()
                .map(new Function<List<CachedMovie>, List<MovieEntity>>() {
                    @Override
                    public List<MovieEntity> apply(List<CachedMovie> mCachedMovies) throws Exception {
                        List<MovieEntity> mMovieEntities = new ArrayList<>();
                        for (CachedMovie mModel : mCachedMovies) {
                            mMovieEntities.add(mMovieMapper.mapFromCache(mModel));
                        }
                        return mMovieEntities;
                    }
                });
    }

    @Override
    public Observable<DetailedMovieEntity> getDetailedMovieFromCache(int mMovieId) {
        return mDataBase.getMoviesDao().getDetailedMovieFromCache(mMovieId).toObservable()
                .map(new Function<CachedDetailedMovie, DetailedMovieEntity>() {
                    @Override
                    public DetailedMovieEntity apply(CachedDetailedMovie mCachedDetailedMovie) throws Exception {
                        return mDetailedMovieMapper.mapFromCache(mCachedDetailedMovie);
                    }
                });
    }

    @Override
    public Observable<List<GenresEntity>> getGenresFromCache() {
        return mDataBase.getMoviesDao().getAllGenresFromCache().toObservable()
                .map(new Function<List<CachedGenres>, List<GenresEntity>>() {
                    @Override
                    public List<GenresEntity> apply(List<CachedGenres> mCachedGenres) throws Exception {
                        List<GenresEntity> mGenresEntities = new ArrayList<>();
                        for (CachedGenres mModel : mCachedGenres) {
                            mGenresEntities.add(mGenreMapper.mapFromCache(mModel));
                        }
                        return mGenresEntities;
                    }
                });
    }

    @Override
    public Observable<List<MovieEntity>> getSpecialGenreMoviesFromCache(int mGenreId) {
        int[] mMovieIds = mDataBase.getMoviesDao().getSpecialGenreMoiveIdsFromCache(mGenreId);
        return mDataBase.getMoviesDao().getSpecialGenreMoviesFromCache(mMovieIds).toObservable()
                .map(new Function<List<CachedMovie>, List<MovieEntity>>() {
                    @Override
                    public List<MovieEntity> apply(List<CachedMovie> mCachedMovies) throws Exception {
                        List<MovieEntity> mMovieEntities = new ArrayList<>();
                        for (CachedMovie mModel : mCachedMovies) {
                            mMovieEntities.add(mMovieMapper.mapFromCache(mModel));
                        }
                        return mMovieEntities;
                    }
                });
    }

    @Override
    public Completable registerMovieToCache(UserMovieEntity mMoview) {
        return null;
    }

    @Override
    public Single<Boolean> areMoviesCached() {
        return mDataBase.getMoviesDao().getAllMoviesFromCache().isEmpty()
                .map(new Function<Boolean, Boolean>() {
                    @Override
                    public Boolean apply(Boolean mIsEmpty) throws Exception {
                        return !mIsEmpty;
                    }
                });
    }

    @Override
    public Completable setLastCacheTime(final long mLastTime) {
        return Completable.defer(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                mDataBase.getConfigDao().insertConfig(new Config(mLastTime));
                return Completable.complete();
            }
        });
    }

    @Override
    public Single<Boolean> isCacheExpired() {
        final long mCurrentTime = System.currentTimeMillis();
        final long mExpirationTime = (long) (60 * 10 * 1000);
        return mDataBase.getConfigDao().getConfig().map(new Function<Config, Boolean>() {
            @Override
            public Boolean apply(Config mConfig) throws Exception {
                return mCurrentTime - mConfig.getLastCacheTime() > mExpirationTime;
            }
        });
    }
}
