package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.model.DomainGenresModel;
import com.mohammad.domain.repository.MoviesRepository;

import java.util.List;

import io.reactivex.Observable;

public class GetGenres extends ObservableUseCase<List<DomainGenresModel>,Void> {

    private MoviesRepository mRepository;

    public GetGenres(MoviesRepository mRepository, PostExecutionThread mPostExecutionThread) {
        super(mPostExecutionThread);
        this.mRepository = mRepository ;
    }

    @Override
    public Observable<List<DomainGenresModel>> buildObservableUseCase(Void mParams) {
        return mRepository.getGenres();
    }
}
