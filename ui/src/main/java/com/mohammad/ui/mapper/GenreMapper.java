package com.mohammad.ui.mapper;

import com.mohammad.presentation.model.GenreView;
import com.mohammad.ui.model.Genre;

public class GenreMapper implements ViewMapper<GenreView, Genre> {
    @Override
    public Genre mapToView(GenreView mPresentation) {
        return new Genre(mPresentation.getId(),mPresentation.getName());
    }
}
