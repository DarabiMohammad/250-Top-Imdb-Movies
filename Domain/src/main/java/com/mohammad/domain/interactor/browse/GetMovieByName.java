package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.model.BaseDomainMovieModel;
import com.mohammad.domain.repository.MoviesRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class GetMovieByName extends ObservableUseCase<List<BaseDomainMovieModel>, GetMovieByName.Params> {

    private MoviesRepository mRepository;

    public GetMovieByName(MoviesRepository mRepository, PostExecutionThread mPostExecutionThread) {
        super(mPostExecutionThread);
        this.mRepository = mRepository;
    }

    @Override
    public Observable<List<BaseDomainMovieModel>> buildObservableUseCase(Params mParams) {
        return mRepository.getMoviesByName(mParams.mName,mParams.mPageNumber);
    }

    public static final class Params{

        private final String mName ;
        private final int mPageNumber;

        private Params(@NonNull String mName, @Nullable int mPageNumber) {
            this.mName = mName;
            this.mPageNumber = mPageNumber;
        }

        public static Params forMovie(String mName,int mPageNumber){
            return new Params(mName,mPageNumber);
        }
    }
}
