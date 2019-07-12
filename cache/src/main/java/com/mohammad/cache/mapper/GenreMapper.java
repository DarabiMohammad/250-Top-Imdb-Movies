package com.mohammad.cache.mapper;

import com.mohammad.cache.model.CachedGenres;
import com.mohammad.data.model.GenresEntity;

public class GenreMapper extends CacheMapper<CachedGenres, GenresEntity> {

    @Override
    public GenresEntity mapFromCache(CachedGenres mCacheModel) {
        return new GenresEntity(mCacheModel.getId(), mCacheModel.getName());
    }

    @Override
    public CachedGenres mapToCache(GenresEntity mEntityModel) {
        return new CachedGenres(mEntityModel.getId(), mEntityModel.getName());
    }
}
