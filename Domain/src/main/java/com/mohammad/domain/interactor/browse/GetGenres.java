package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.model.GenresModel;
import com.mohammad.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetGenres extends ObservableUseCase<List<GenresModel>,Void> {

    private MoviesRepository mRepository;

    @Inject
    public GetGenres(MoviesRepository mRepository, PostExecutionThread mPostExecutionThread) {
        super(mPostExecutionThread);
        this.mRepository = mRepository ;
    }

    @Override
    public Observable<List<GenresModel>> buildObservableUseCase(Void mParams) {
        return mRepository.getGenres();
    }
}
