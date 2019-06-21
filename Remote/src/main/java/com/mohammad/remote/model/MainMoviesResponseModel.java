package com.mohammad.remote.model;

import com.google.gson.annotations.SerializedName;
import com.mohammad.remote.model.common.MovieModel;

import java.util.List;

public class MainMoviesResponseModel {

    @SerializedName("data")
    private List<MovieModel> mMovies ;

    public MainMoviesResponseModel(List<MovieModel> mMovies) {
        this.mMovies = mMovies;
    }

    public List<MovieModel> getMovies() {
        return mMovies;
    }
}
