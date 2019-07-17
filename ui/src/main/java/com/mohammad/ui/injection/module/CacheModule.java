package com.mohammad.ui.injection.module;

import android.app.Application;

import com.mohammad.cache.MoviesCacheImp;
import com.mohammad.cache.db.MoviesDataBase;
import com.mohammad.data.repository.MoviesCache;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class CacheModule {

    @Provides
    static MoviesDataBase provideDataBase(Application mApplication){
        return MoviesDataBase.getInstance(mApplication);
    }

//    @Provides
//    static MoviesCacheImp provideMoviesCacheImp(Context mContext, MoviesDataBase mDataBase,
//                                                MovieMapper mMovieMapper,
//                                                DetailedMovieMapper mDetailedMovieMapper,
//                                                GenreMapper mGenreMapper) {
//        return new MoviesCacheImp(mContext,mDataBase,mMovieMapper,mDetailedMovieMapper,mGenreMapper);
//    }

    @Binds
    abstract MoviesCache bindMoviesCache(MoviesCacheImp mMoviesCache);
}
