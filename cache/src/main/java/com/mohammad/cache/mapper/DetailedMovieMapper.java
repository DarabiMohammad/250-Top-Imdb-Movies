package com.mohammad.cache.mapper;

import com.mohammad.cache.model.CachedDetailedMovie;
import com.mohammad.data.model.DetailedMovieEntity;

public class DetailedMovieMapper implements CacheMapper<CachedDetailedMovie, DetailedMovieEntity> {

    @Override
    public DetailedMovieEntity mapFromCache(CachedDetailedMovie mCacheModel) {
        return new DetailedMovieEntity(mCacheModel.getDetailedMovieId(),
                mCacheModel.getTitle(),mCacheModel.getPoster(),mCacheModel.getGenres(),
                mCacheModel.getImages(),mCacheModel.getYear(),mCacheModel.getCountry(),
                mCacheModel.getImdbRating(),mCacheModel.getRated(),mCacheModel.getActors(),
                mCacheModel.getRuntime(),mCacheModel.getDirector(),mCacheModel.getWriter(),
                mCacheModel.getActors(),mCacheModel.getPlot(),mCacheModel.getAwards(),
                mCacheModel.getMetaScore(),mCacheModel.getImdbVotes(),mCacheModel.getImdbId(),
                mCacheModel.getType());
    }

    @Override
    public CachedDetailedMovie mapToCache(DetailedMovieEntity mEntityModel) {
        return new CachedDetailedMovie(mEntityModel.getId(),
                mEntityModel.getTitle(),mEntityModel.getPoster(),mEntityModel.getGenres(),
                mEntityModel.getImages(),mEntityModel.getYear(),mEntityModel.getCountry(),
                mEntityModel.getImdbRating(),mEntityModel.getRated(),mEntityModel.getActors(),
                mEntityModel.getRuntime(),mEntityModel.getDirector(),mEntityModel.getWriter(),
                mEntityModel.getActors(),mEntityModel.getPlot(),mEntityModel.getAwards(),
                mEntityModel.getMetaScore(),mEntityModel.getImdbVotes(),mEntityModel.getImdbId(),
                mEntityModel.getType());
    }
}
