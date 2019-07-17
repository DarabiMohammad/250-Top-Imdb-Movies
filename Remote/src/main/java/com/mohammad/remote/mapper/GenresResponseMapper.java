package com.mohammad.remote.mapper;

import com.mohammad.data.model.GenresEntity;
import com.mohammad.remote.model.common.GenreModel;

import javax.inject.Inject;

public class GenresResponseMapper implements MoviesMapper<GenreModel, GenresEntity> {

    @Inject
    public GenresResponseMapper() {
    }

    @Override
    public GenresEntity mapFromModel(GenreModel mModel) {
        return new GenresEntity(mModel.getId(),mModel.getName());
    }
}
