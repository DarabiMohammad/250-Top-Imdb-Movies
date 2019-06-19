package com.mohammad.data.mapper;

import com.mohammad.data.model.MovieEntity;
import com.mohammad.domain.model.MovieModel;

import javax.inject.Inject;

public class MovieMapper implements EntityMapper<MovieEntity, MovieModel> {

    @Inject
    MovieMapper(){}

    @Override
    public MovieModel mapFromEntity(MovieEntity mEntity) {
        return new MovieModel(mEntity.getId(),mEntity.getTitle(),
                mEntity.getPoster(),mEntity.getGenres(),mEntity.getImages());
    }

    @Override
    public MovieEntity mapToEntity(MovieModel mDomain) {
        return new MovieEntity(mDomain.getId(),mDomain.getTitle(),
                mDomain.getPoster(),mDomain.getGenres(),mDomain.getImages());
    }
}
