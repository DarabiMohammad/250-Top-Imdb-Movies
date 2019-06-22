package com.mohammad.cache.mapper;

import com.mohammad.cache.model.CachedMovie;
import com.mohammad.data.model.MovieEntity;

public class MovieMapper implements CacheMapper<CachedMovie, MovieEntity> {

    @Override
    public MovieEntity mapFromCache(CachedMovie mCacheModel) {
        return new MovieEntity(mCacheModel.getId(),mCacheModel.getTitle(),
                mCacheModel.getPoster(),mCacheModel.getGenres(),mCacheModel.getImages());
    }

    @Override
    public CachedMovie mapToCache(MovieEntity mEntityModel) {
        return new CachedMovie(mEntityModel.getId(),mEntityModel.getTitle(),
                mEntityModel.getPoster(),mEntityModel.getGenres(), mEntityModel.getImages());
    }
}
