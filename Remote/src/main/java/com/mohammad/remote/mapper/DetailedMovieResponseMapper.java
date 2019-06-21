package com.mohammad.remote.mapper;

import com.mohammad.data.model.DetailedMovieEntity;
import com.mohammad.remote.model.common.DetailedMovieModel;

public class DetailedMovieResponseMapper implements MoviesMapper<DetailedMovieModel, DetailedMovieEntity> {

    @Override
    public DetailedMovieEntity mapFromModel(DetailedMovieModel mModel) {
        return new DetailedMovieEntity(mModel.getId(),mModel.getTitle(),
                mModel.getPoster(),mModel.getGenres(),mModel.getImages(),
                mModel.getYear(),mModel.getCountry(),mModel.getImdbRating(),
                mModel.getRated(),mModel.getReleasd(),mModel.getRuntime(),mModel.getDirector(),
                mModel.getWriter(),mModel.getmActors(),mModel.getPlot(),mModel.getAwards(),
                mModel.getMetaScore(),mModel.getImdbVotes(),mModel.getImdbId(),mModel.getType());
    }
}
