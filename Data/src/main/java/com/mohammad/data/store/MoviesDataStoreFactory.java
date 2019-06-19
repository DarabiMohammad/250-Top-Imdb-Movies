package com.mohammad.data.store;

import com.mohammad.data.repository.MoviesDataStore;

import javax.inject.Inject;

public class MoviesDataStoreFactory {

    private MoviesCacheImpl mCacheMoviesImpl ;
    private MoviesRemoteImpl mRemoteMoviesImpl ;

    @Inject
    public MoviesDataStoreFactory(MoviesCacheImpl mCacheMoviesImpl, MoviesRemoteImpl mRemoteMoviesImpl) {
        this.mCacheMoviesImpl = mCacheMoviesImpl;
        this.mRemoteMoviesImpl = mRemoteMoviesImpl;
    }

    public MoviesDataStore getMoviesDataStore(boolean mIsCachedMovies,boolean mIsExpiredCacheTime){
        if(mIsCachedMovies && !mIsExpiredCacheTime)
            return mCacheMoviesImpl;
        return mRemoteMoviesImpl;
    }

    public MoviesCacheImpl getCacheMoviesDataStore(){
        return mCacheMoviesImpl ;
    }
}
