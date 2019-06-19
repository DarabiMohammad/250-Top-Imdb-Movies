package com.mohammad.data.repository;

import com.mohammad.data.model.MovieEntity;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesRemote {

    Observable<List<MovieEntity>> getAllMovies();
}