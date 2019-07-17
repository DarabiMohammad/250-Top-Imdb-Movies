package com.mohammad.ui.injection.module;

import dagger.Module;

@Module
public abstract class DataModule {

//    @Provides
//    static MoviesDataRepository provideMoviesDataRepository(MovieMapper mMovieMapper,
//                                                            DetailedMovieMapper mDetailedMovieMapper,
//                                                            UserMovieMapper mUserMovieMapper,
//                                                            GenreMapper mGenreMapper,
//                                                            MoviesCache mMoviesCache,
//                                                            MoviesDataStoreFactory mFactory) {
//        return new MoviesDataRepository(mMovieMapper, mDetailedMovieMapper, mUserMovieMapper,
//                mGenreMapper,mMoviesCache,mFactory);
//    }

//    @Provides
//    static MoviesCacheImpl provideMoviesCacheImpl(MoviesCache mCache){
//        return new MoviesCacheImpl(mCache);
//    }

//    @Provides
//    static MoviesDataStoreFactory provideMoviesDataStoreFactory(MoviesCacheImpl mCacheMoviesImpl, MoviesRemoteImpl mRemoteMoviesImpl) {
//        return new MoviesDataStoreFactory(mCacheMoviesImpl,mRemoteMoviesImpl);
//    }

//    @Provides
//    static MoviesRemoteImpl provideMoviesRemoteImpl(MoviesRemote mRemote){
//        return new MoviesRemoteImpl(mRemote);
//    }
}
