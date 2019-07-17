package com.mohammad.presentation;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.mohammad.domain.interactor.browse.GetAllMovies;
import com.mohammad.domain.interactor.browse.GetGenres;
import com.mohammad.domain.interactor.browse.GetMovieByName;
import com.mohammad.domain.interactor.browse.GetMovieDetail;
import com.mohammad.domain.interactor.browse.GetSpecialGenreMovies;
import com.mohammad.domain.model.DetailedMovieModel;
import com.mohammad.domain.model.GenresModel;
import com.mohammad.domain.model.MovieModel;
import com.mohammad.presentation.mapper.DetailedMovieViewMapper;
import com.mohammad.presentation.mapper.GenresViewMapper;
import com.mohammad.presentation.mapper.MovieViewMapper;
import com.mohammad.presentation.model.DetailedMovieView;
import com.mohammad.presentation.model.GenreView;
import com.mohammad.presentation.model.MovieView;
import com.mohammad.presentation.state.Resource;
import com.mohammad.presentation.state.ResourceState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class MoviesViewModel extends ViewModel {

    private GetAllMovies mGetAllMovies;
    private GetMovieByName mGetMovieByName;
    private GetMovieDetail mGetDetailedMovie;
    private GetSpecialGenreMovies mGetSpecialGenreMovies;
    private GetGenres mGetGenres;

    private MovieViewMapper mMovieMapper;
    private DetailedMovieViewMapper mDetailedMovieMapper;
    private GenresViewMapper mGenresMapper;

    private MutableLiveData<Resource<List<MovieView>>> mMovieLiveData;
    private MutableLiveData<Resource<List<MovieView>>> mMoviesByNameLiveData;
    private MutableLiveData<Resource<List<MovieView>>> mSpecialGenreMoviesLiveData;
    private MutableLiveData<Resource<DetailedMovieView>> mDetailedMovieLiveData;
    private MutableLiveData<Resource<List<GenreView>>> mGenresLiveData;

    @Inject
    public MoviesViewModel(GetAllMovies mGetAllMovies, GetMovieByName mGetMovieByName,
                           GetMovieDetail mGetDetailedMovie,
                           GetSpecialGenreMovies mGetSpecialGenreMovies,
                           GetGenres mGetGenres, MovieViewMapper mMovieMapper,
                           DetailedMovieViewMapper mDetailedMovieMapper,
                           GenresViewMapper mGenresMapper) {
        this.mGetAllMovies = mGetAllMovies;
        this.mGetMovieByName = mGetMovieByName;
        this.mGetDetailedMovie = mGetDetailedMovie;
        this.mGetSpecialGenreMovies = mGetSpecialGenreMovies;
        this.mGetGenres = mGetGenres;
        this.mMovieMapper = mMovieMapper;
        this.mDetailedMovieMapper = mDetailedMovieMapper;
        this.mGenresMapper = mGenresMapper;

        mMovieLiveData = new MutableLiveData<>();
        mMoviesByNameLiveData = new MutableLiveData<>();
        mSpecialGenreMoviesLiveData = new MutableLiveData<>();
        mDetailedMovieLiveData = new MutableLiveData<>();
        mGenresLiveData = new MutableLiveData<>();

    }

    @Override
    protected void onCleared() {
        mGetAllMovies.dispose();
        mGetMovieByName.dispose();
        mGetDetailedMovie.dispose();
        mGetSpecialGenreMovies.dispose();
        mGetGenres.dispose();
        super.onCleared();
    }

    public MutableLiveData<Resource<List<MovieView>>> getMovieLiveData() {
        return mMovieLiveData;
    }

    public MutableLiveData<Resource<List<MovieView>>> getMoviesByNameLiveData() {
        return mMoviesByNameLiveData;
    }

    public MutableLiveData<Resource<List<MovieView>>> getSpecialGenreMoviesLiveData() {
        return mSpecialGenreMoviesLiveData;
    }

    public MutableLiveData<Resource<DetailedMovieView>> getDetailedMovieLiveData() {
        return mDetailedMovieLiveData;
    }

    public MutableLiveData<Resource<List<GenreView>>> getGenresLiveData() {
        return mGenresLiveData;
    }

    public void fetchMovies(int mPageNumber) {
        mMovieLiveData.postValue(new Resource<List<MovieView>>(ResourceState.LOADING, null, null));
        mGetAllMovies.execute(new MoviesSubsciber(), new GetAllMovies.Params(mPageNumber));

    }

    public void fetchMoviesByName(String mName, int mPageNumber) {
        mMoviesByNameLiveData.postValue(new Resource<List<MovieView>>(ResourceState.LOADING, null, null));
        mGetMovieByName.execute(new MoviesByNameSubscriber(), new GetMovieByName.Params(mName, mPageNumber));
    }

    public void fetchSpecialGenreMovies(int mGenreId, int mPageNimber) {
        mSpecialGenreMoviesLiveData.postValue(new Resource<List<MovieView>>(ResourceState.LOADING, null, null));
        mGetSpecialGenreMovies.execute(new SpecialGenreMoviesSubscriber(), new GetSpecialGenreMovies.Params(mGenreId, mPageNimber));
    }

    public void fetchDetailedMovies(int mMovieId) {
        mDetailedMovieLiveData.postValue(new Resource<DetailedMovieView>(ResourceState.LOADING,
                null, null));
        mGetDetailedMovie.execute(new DetailedMoviesSubscriber(), new GetMovieDetail.Params(mMovieId));
    }

    public void fetchGenres() {
        mGenresLiveData.postValue(new Resource<List<GenreView>>(ResourceState.LOADING, null, null));
        mGetGenres.execute(new GenresSubscriber(), null);
    }

    private class MoviesSubsciber extends DisposableObserver<List<MovieModel>> {

        @Override
        public void onNext(List<MovieModel> mMovieModels) {
            List<MovieView> mMovies = new ArrayList<>();
            for (MovieModel mModel : mMovieModels) {
                mMovies.add(mMovieMapper.mapToView(mModel));
            }
            mMovieLiveData.postValue(new Resource<>(ResourceState.SUCCESS,
                    mMovies, null));
        }

        @Override
        public void onError(Throwable e) {
            mMovieLiveData.postValue(new Resource<List<MovieView>>(ResourceState.ERROR, null,
                    e.getMessage()));
        }

        @Override
        public void onComplete() {
        }
    }

    private class MoviesByNameSubscriber extends DisposableObserver<List<MovieModel>> {

        @Override
        public void onNext(List<MovieModel> mMovieModels) {
            List<MovieView> mMovies = new ArrayList<>();
            for (MovieModel mModel : mMovieModels) {
                mMovies.add(mMovieMapper.mapToView(mModel));
            }
            mMoviesByNameLiveData.postValue(new Resource<>(ResourceState.SUCCESS,
                    mMovies, null));
        }

        @Override
        public void onError(Throwable e) {
            mMoviesByNameLiveData.postValue(new Resource<List<MovieView>>(ResourceState.ERROR, null,
                    e.getMessage()));
        }

        @Override
        public void onComplete() {

        }
    }

    private class SpecialGenreMoviesSubscriber extends DisposableObserver<List<MovieModel>> {

        @Override
        public void onNext(List<MovieModel> mMovieModels) {
            List<MovieView> mMovies = new ArrayList<>();
            for (MovieModel mModel : mMovieModels) {
                mMovies.add(mMovieMapper.mapToView(mModel));
            }
            mSpecialGenreMoviesLiveData.postValue(new Resource<>(ResourceState.SUCCESS,
                    mMovies, null));
        }

        @Override
        public void onError(Throwable e) {
            mSpecialGenreMoviesLiveData.postValue(new Resource<List<MovieView>>(ResourceState.ERROR,null,
                    e.getMessage()));
        }

        @Override
        public void onComplete() {

        }
    }

    private class DetailedMoviesSubscriber extends DisposableObserver<DetailedMovieModel> {

        @Override
        public void onNext(DetailedMovieModel mDetailedMovieModel) {
            mDetailedMovieLiveData.postValue(new Resource<>(ResourceState.SUCCESS,
                    mDetailedMovieMapper.mapToView(mDetailedMovieModel), null));
        }

        @Override
        public void onError(Throwable e) {
            mDetailedMovieLiveData.postValue(new Resource<DetailedMovieView>(ResourceState.ERROR,
                    null, e.getMessage()));
        }

        @Override
        public void onComplete() {

        }
    }

    private class GenresSubscriber extends DisposableObserver<List<GenresModel>> {

        @Override
        public void onNext(List<GenresModel> mGenresModels) {
            List<GenreView> mGenres = new ArrayList<>();
            for (GenresModel mModel : mGenresModels) {
                mGenres.add(mGenresMapper.mapToView(mModel));
            }
            mGenresLiveData.postValue(new Resource<>(ResourceState.SUCCESS,
                    mGenres, null));
        }

        @Override
        public void onError(Throwable e) {
            mGenresLiveData.postValue(new Resource<List<GenreView>>(ResourceState.ERROR, null,
                    e.getMessage()));
        }

        @Override
        public void onComplete() {

        }
    }
}
