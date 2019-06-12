package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.repository.MoviesRepository;

import io.reactivex.Observable;

public class GetAllMovies extends ObservableUseCase {

    private MoviesRepository mRepository ;

    public GetAllMovies(MoviesRepository mRepository,PostExecutionThread mExecutionThread){
        super(mExecutionThread);
        this.mRepository = mRepository;
    }

    @Override
    public Observable buildObservableUseCase(Object mParams) {
        return mRepository.getAllMovies();
    }
}
