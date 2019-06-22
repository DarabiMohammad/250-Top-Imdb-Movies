package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.model.MovieModel;
import com.mohammad.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetSpecialGenreMovies extends ObservableUseCase<List<MovieModel>, GetSpecialGenreMovies.Params> {

    private MoviesRepository mRepository ;

    @Inject
    public GetSpecialGenreMovies(MoviesRepository mRepository ,PostExecutionThread mPostExecutionThread) {
        super(mPostExecutionThread);
        this.mRepository = mRepository ;
    }

    @Override
    public Observable<List<MovieModel>> buildObservableUseCase(Params mParams) {
        return mRepository.getSpecialGenreMovies(mParams.mGenreId,mParams.mPageNumber);
    }

    public static final class Params {

        private int mGenreId;
        private int mPageNumber;

        public Params(int mGenreId, int mPageNumber) {
            this.mGenreId = mGenreId;
            this.mPageNumber = mPageNumber;
        }

        public int getPageNumber(){
            return mPageNumber;
        }

        public int getGenreId() {
            return mGenreId;
        }
    }
}
