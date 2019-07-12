package com.mohammad.ui.mapper;

import com.mohammad.presentation.model.MovieView;
import com.mohammad.ui.model.Movie;

public class MovieMapper implements ViewMapper<MovieView, Movie> {
    @Override
    public Movie mapToView(MovieView mPresentation) {
        return new Movie(mPresentation.getId(),mPresentation.getTitle(),
                mPresentation.getPoster(),mPresentation.getGenres(),
                mPresentation.getImages());
    }
}
