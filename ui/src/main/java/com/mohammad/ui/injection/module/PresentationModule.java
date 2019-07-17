package com.mohammad.ui.injection.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.mohammad.data.MoviesDataRepository;
import com.mohammad.domain.repository.MoviesRepository;
import com.mohammad.presentation.MoviesViewModel;
import com.mohammad.ui.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = MoviesViewModel.class)
    abstract ViewModel bindViewModel(MoviesViewModel mViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory mViewModelFactory);

//    @Provides
//    static GetAllMovies provideGetAllMovies(MoviesRepository mRepository, PostExecutionThread mExecutionThread) {
//        return new GetAllMovies(mRepository, mExecutionThread);
//    }

    @Binds
    abstract MoviesRepository bindMoviesRepository(MoviesDataRepository mMoviesDataRepository);
}
