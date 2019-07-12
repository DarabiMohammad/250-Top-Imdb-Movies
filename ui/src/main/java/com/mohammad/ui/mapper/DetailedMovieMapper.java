package com.mohammad.ui.mapper;

import com.mohammad.presentation.model.DetailedMovieView;
import com.mohammad.ui.model.DetailedMovie;

public class DetailedMovieMapper implements ViewMapper<DetailedMovieView, DetailedMovie> {
    @Override
    public DetailedMovie mapToView(DetailedMovieView mPresentation) {
        return new DetailedMovie(mPresentation.getId(),mPresentation.getTitle(),
                mPresentation.getPoster(),mPresentation.getGenres(),mPresentation.getImages(),
                mPresentation.getYear(),mPresentation.getCountry(),mPresentation.getImdbRating(),
                mPresentation.getRated(),mPresentation.getReleasd(),mPresentation.getRuntime(),
                mPresentation.getDirector(), mPresentation.getWriter(),mPresentation.getmActors(),
                mPresentation.getPlot(),mPresentation.getAwards(), mPresentation.getMetaScore(),
                mPresentation.getImdbVotes(),mPresentation.getImdbId(),mPresentation.getType());
    }
}
