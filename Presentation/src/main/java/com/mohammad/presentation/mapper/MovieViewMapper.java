package com.mohammad.presentation.mapper;

import com.mohammad.domain.model.MovieModel;
import com.mohammad.presentation.model.MovieView;

public class MovieViewMapper implements MoviesMapper<MovieView, MovieModel> {

    @Override
    public MovieView mapToView(MovieModel mData) {
        return new MovieView(mData.getId(), mData.getTitle(), mData.getPoster(),
                mData.getGenres(), mData.getImages());
    }
}
