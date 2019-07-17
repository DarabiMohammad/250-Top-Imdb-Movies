package com.mohammad.presentation.mapper;

import com.mohammad.domain.model.DetailedMovieModel;
import com.mohammad.presentation.model.DetailedMovieView;

import javax.inject.Inject;

public class DetailedMovieViewMapper implements MoviesMapper<DetailedMovieView, DetailedMovieModel> {

    @Inject
    public DetailedMovieViewMapper() {
    }

    @Override
    public DetailedMovieView mapToView(DetailedMovieModel mData) {
        return new DetailedMovieView(mData.getId(),mData.getTitle(),
                mData.getPoster(),mData.getGenres(),mData.getImages(),
                mData.getYear(),mData.getCountry(),mData.getImdbRating(),
                mData.getRated(),mData.getReleasd(),mData.getRuntime(),mData.getDirector(),
                mData.getWriter(),mData.getmActors(),mData.getPlot(),mData.getAwards(),
                mData.getMetaScore(),mData.getImdbVotes(),mData.getImdbId(),mData.getType());
    }
}
