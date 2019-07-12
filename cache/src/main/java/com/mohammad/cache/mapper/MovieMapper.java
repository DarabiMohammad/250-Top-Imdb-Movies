package com.mohammad.cache.mapper;

import com.mohammad.cache.model.CachedDetailedMovie;
import com.mohammad.data.model.MovieEntity;

public class MovieMapper extends CacheMapper<CachedDetailedMovie, MovieEntity> {

    @Override
    public MovieEntity mapFromCache(CachedDetailedMovie mCacheModel) {
        return new MovieEntity(mCacheModel.getId(), mCacheModel.getTitle(),
                mCacheModel.getPoster(), fromString(mCacheModel.getGenres()), fromString(mCacheModel.getImages()));
    }

    @Override
    public CachedDetailedMovie mapToCache(MovieEntity mEntityModel) {
        return new CachedDetailedMovie(mEntityModel.getId(), mEntityModel.getTitle(),
                mEntityModel.getPoster(), toString(mEntityModel.getGenres()), toString(mEntityModel.getImages()),
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null);
    }
}
