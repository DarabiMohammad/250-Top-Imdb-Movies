package com.mohammad.ui.injection.module;

import com.mohammad.data.MoviesDataRepository;
import com.mohammad.domain.repository.MoviesRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {

    @Binds
    abstract MoviesRepository bindDataRepository(MoviesDataRepository mMoviesDataRepository);
}
