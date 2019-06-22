package com.mohammad.presentation.mapper;

import com.mohammad.domain.model.GenresModel;
import com.mohammad.presentation.model.GenreView;

public class GenresViewMapper implements MoviesMapper<GenreView, GenresModel> {

    @Override
    public GenreView mapToView(GenresModel mData) {
        return new GenreView(mData.getId(),mData.getName());
    }
}
