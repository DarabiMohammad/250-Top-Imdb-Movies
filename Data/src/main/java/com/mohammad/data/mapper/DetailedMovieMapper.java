package com.mohammad.data.mapper;

import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.domain.model.DetailedMovieModel;

import javax.inject.Inject;

public class DetailedMovieMapper implements EntityMapper<DetailedMovieEntity, DetailedMovieModel> {

    @Inject
    DetailedMovieMapper(){}

    @Override
    public DetailedMovieModel mapFromEntity(DetailedMovieEntity mEntity) {
        return new DetailedMovieModel(mEntity.getId(),mEntity.getTitle(),
                mEntity.getPoster(),mEntity.getGenres(),mEntity.getImages(),
                mEntity.getYear(),mEntity.getCountry(),mEntity.getImdbRating(),
                mEntity.getRated(),mEntity.getReleasd(),mEntity.getRuntime(),
                mEntity.getDirector(),mEntity.getWriter(),mEntity.getActors(),
                mEntity.getPlot(),mEntity.getAwards(),mEntity.getMetaScore(),
                mEntity.getImdbVotes(),mEntity.getImdbId(),mEntity.getType());
    }

    @Override
    public DetailedMovieEntity mapToEntity(DetailedMovieModel mDomain) {
        return new DetailedMovieEntity(mDomain.getId(),mDomain.getTitle(),
                mDomain.getPoster(),mDomain.getGenres(),mDomain.getImages(),
                mDomain.getYear(),mDomain.getCountry(),mDomain.getImdbRating(),
                mDomain.getRated(),mDomain.getReleasd(),mDomain.getRuntime(),
                mDomain.getDirector(),mDomain.getWriter(),mDomain.getmActors(),
                mDomain.getPlot(),mDomain.getAwards(),mDomain.getMetaScore(),
                mDomain.getImdbVotes(),mDomain.getImdbId(),mDomain.getType());
    }
}
