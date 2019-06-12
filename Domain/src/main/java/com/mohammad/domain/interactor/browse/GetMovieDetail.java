package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.model.DetailedDomainMovieModel;
import com.mohammad.domain.repository.MoviesRepository;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class GetMovieDetail extends ObservableUseCase<DetailedDomainMovieModel, GetMovieDetail.Params> {

    private MoviesRepository mRepository;

    public GetMovieDetail(MoviesRepository mRepository, PostExecutionThread mPostExecutionThread) {
        super(mPostExecutionThread);
        this.mRepository = mRepository;
    }

    @Override
    public Observable<DetailedDomainMovieModel> buildObservableUseCase(Params mParams) {
        return mRepository.getMovieDetail(mParams.mMovieId);
    }

    public static final class Params {

        private int mMovieId;

        private Params(int mMovieId) {
            this.mMovieId = mMovieId;
        }

        public Params forMovie(@NonNull int mMovieId) {
            return new Params(mMovieId);
        }
    }
}
