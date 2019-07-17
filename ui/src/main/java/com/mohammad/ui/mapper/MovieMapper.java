package com.mohammad.ui.mapper;

import com.mohammad.presentation.model.MovieView;
import com.mohammad.ui.model.Movie;

import javax.inject.Inject;

public class MovieMapper implements ViewMapper<MovieView, Movie> {

    @Inject
    public MovieMapper(){}

    @Override
    public Movie mapToView(MovieView mPresentation) {
        return new Movie(mPresentation.getId(),mPresentation.getTitle(),
                mPresentation.getPoster(),mPresentation.getGenres(),
                mPresentation.getImages());
    }
}
