package com.mohammad.data.mapper;

import com.mohammad.data.model.GenresEntity;
import com.mohammad.domain.model.GenresModel;

import javax.inject.Inject;

public class GenreMapper implements EntityMapper<GenresEntity, GenresModel> {

    @Inject
    GenreMapper(){}

    @Override
    public GenresModel mapFromEntity(GenresEntity mEntity) {
        return new GenresModel(mEntity.getId(),mEntity.getName());
    }

    @Override
    public GenresEntity mapToEntity(GenresModel mDomain) {
        return new GenresEntity(mDomain.getId(),mDomain.getName());
    }
}
