package com.mohammad.remote.mapper;

import com.mohammad.data.model.MovieEntity;
import com.mohammad.remote.model.common.MovieModel;

public class MoviesResponseMapper implements MoviesMapper<MovieModel, MovieEntity> {

    @Override
    public MovieEntity mapFromModel(MovieModel mModel) {
        return new MovieEntity(mModel.getId(),mModel.getTitle(),mModel.getPoster(),
                mModel.getGenres(),mModel.getImages());
    }
}
