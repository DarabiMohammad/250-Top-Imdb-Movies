package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.model.DetailedMovieModel;
import com.mohammad.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetMovieDetail extends ObservableUseCase<DetailedMovieModel, GetMovieDetail.Params> {

    private MoviesRepository mRepository;

    @Inject
    public GetMovieDetail(MoviesRepository mRepository, PostExecutionThread mPostExecutionThread) {
        super(mPostExecutionThread);
        this.mRepository = mRepository;
    }

    @Override
    public Observable<DetailedMovieModel> buildObservableUseCase(Params mParams) {
        return mRepository.getMovieDetail(mParams.mMovieId);
    }

    public static final class Params {

        private int mMovieId;

        public Params(int mMovieId) {
            this.mMovieId = mMovieId;
        }

        public int forMovie() {
            return mMovieId;
        }
    }
}
