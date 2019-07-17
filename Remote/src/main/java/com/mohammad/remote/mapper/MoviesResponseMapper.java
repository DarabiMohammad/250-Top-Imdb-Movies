package com.mohammad.remote.mapper;

import com.mohammad.data.model.MovieEntity;
import com.mohammad.remote.model.common.MovieModel;

import javax.inject.Inject;

public class MoviesResponseMapper implements MoviesMapper<MovieModel, MovieEntity> {

    @Inject
    public MoviesResponseMapper() {
    }

    @Override
    public MovieEntity mapFromModel(MovieModel mModel) {
        return new MovieEntity(mModel.getId(),mModel.getTitle(),mModel.getPoster(),
                mModel.getGenres(),mModel.getImages());
    }
}
