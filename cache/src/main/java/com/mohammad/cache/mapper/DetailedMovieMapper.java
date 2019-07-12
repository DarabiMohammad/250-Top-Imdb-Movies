package com.mohammad.cache.mapper;

import com.mohammad.cache.model.CachedDetailedMovie;
import com.mohammad.data.model.DetailedMovieEntity;

import java.io.Serializable;

public class DetailedMovieMapper extends CacheMapper<CachedDetailedMovie, DetailedMovieEntity> implements Serializable {

    @Override
    public DetailedMovieEntity mapFromCache(CachedDetailedMovie mCacheModel) {
        return new DetailedMovieEntity(mCacheModel.getMovieId(),
                mCacheModel.getTitle(),mCacheModel.getPoster(),fromString(mCacheModel.getGenres()),
                fromString(mCacheModel.getImages()),mCacheModel.getYear(),mCacheModel.getCountry(),
                mCacheModel.getImdbRating(),mCacheModel.getRated(),mCacheModel.getActors(),
                mCacheModel.getRuntime(),mCacheModel.getDirector(),mCacheModel.getWriter(),
                mCacheModel.getActors(),mCacheModel.getPlot(),mCacheModel.getAwards(),
                mCacheModel.getMetaScore(),mCacheModel.getImdbVotes(),mCacheModel.getImdbId(),
                mCacheModel.getType());
    }

    @Override
    public CachedDetailedMovie mapToCache(DetailedMovieEntity mEntityModel) {
        return new CachedDetailedMovie(mEntityModel.getId(),
                mEntityModel.getTitle(),mEntityModel.getPoster(),toString(mEntityModel.getGenres()),
                toString(mEntityModel.getImages()),mEntityModel.getYear(),mEntityModel.getCountry(),
                mEntityModel.getImdbRating(),mEntityModel.getRated(),mEntityModel.getActors(),
                mEntityModel.getRuntime(),mEntityModel.getDirector(),mEntityModel.getWriter(),
                mEntityModel.getActors(),mEntityModel.getPlot(),mEntityModel.getAwards(),
                mEntityModel.getMetaScore(),mEntityModel.getImdbVotes(),mEntityModel.getImdbId(),
                mEntityModel.getType());
    }
}
