package com.mohammad.domain.repository;

import com.mohammad.domain.model.DomainMovieModel;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesRepository {

    Observable<List<DomainMovieModel>> getAllMovies();
}
