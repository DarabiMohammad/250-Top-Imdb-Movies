package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.model.MovieModel;
import com.mohammad.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetAllMovies extends ObservableUseCase<List<MovieModel>, GetAllMovies.Params> {

    private MoviesRepository mRepository;

    @Inject
    public GetAllMovies(MoviesRepository mRepository, PostExecutionThread mExecutionThread) {
        super(mExecutionThread);
        this.mRepository = mRepository;
    }

    @Override
    public Observable<List<MovieModel>> buildObservableUseCase(Params mParams) {
        return mRepository.getAllMovies(mParams.mParam);
    }

    public static final class Params {

        private int mParam;

        public Params(int mParam) {
            this.mParam = mParam;
        }

        public int forMovie() {
            return mParam ;
        }
    }
}
