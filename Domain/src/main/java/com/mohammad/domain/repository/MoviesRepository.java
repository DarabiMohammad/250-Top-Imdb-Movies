package com.mohammad.domain.repository;

import com.mohammad.domain.model.BaseDomainMovieModel;
import com.mohammad.domain.model.DetailedDomainMovieModel;
import com.mohammad.domain.model.DomainGenresModel;
import com.mohammad.domain.model.DomainUserMovieModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public interface MoviesRepository {

    Observable<List<BaseDomainMovieModel>> getAllMovies();

    Observable<List<BaseDomainMovieModel>> getMoviesByName(@NonNull String mName, @Nullable int mPageNumber);

    Observable<DetailedDomainMovieModel> getMovieDetail(@NonNull int mMovieId);

    Observable<List<DomainGenresModel>> getGenres();

    Observable<List<BaseDomainMovieModel>> getSpecialGenreMovies(@NonNull int mGenreId,@Nullable int mPageNumber);

    Completable registerMovie(DomainUserMovieModel mMoview);
}
