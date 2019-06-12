package com.mohammad.domain.interactor.browse;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.domain.interactor.ObservableUseCase;
import com.mohammad.domain.model.BaseDomainMovieModel;
import com.mohammad.domain.repository.MoviesRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class GetSpecialGenreMovies extends ObservableUseCase<List<BaseDomainMovieModel>, GetSpecialGenreMovies.Params> {

    private MoviesRepository mRepository ;

    public GetSpecialGenreMovies(MoviesRepository mRepository ,PostExecutionThread mPostExecutionThread) {
        super(mPostExecutionThread);
        this.mRepository = mRepository ;
    }

    @Override
    public Observable<List<BaseDomainMovieModel>> buildObservableUseCase(Params mParams) {
        return mRepository.getSpecialGenreMovies(mParams.mgenreId,mParams.mPageNumber);
    }

    public static final class Params {

        private int mgenreId;
        private int mPageNumber;

        private Params(int mgenreId, int mPageNumber) {
            this.mgenreId = mgenreId;
            this.mPageNumber = mPageNumber;
        }

        public Params forGenre(@NonNull int mgenreId, @Nullable int mPageNumber) {
            return new Params(mgenreId, mPageNumber);
        }
    }
}
