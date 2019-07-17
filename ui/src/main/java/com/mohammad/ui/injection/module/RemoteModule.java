package com.mohammad.ui.injection.module;

import com.mohammad.data.repository.MoviesRemote;
import com.mohammad.remote.MoviesRemoteImp;
import com.mohammad.remote.service.MoviesApiMethods;
import com.mohammad.remote.service.MoviesApiServiceFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RemoteModule {

    @Provides
    static MoviesApiMethods provideApiMethods(){
        return new MoviesApiServiceFactory().makeMoviesApiMethods(true);
    }

//    @Provides
//    static MoviesRemoteImp provideMoviesRemoteImp(MoviesApiMethods mService,
//                                                  MoviesResponseMapper mMoviesMapper,
//                                                  DetailedMovieResponseMapper mDetailedMoviesMapper,
//                                                  GenresResponseMapper mGenresMapper){
//        return new MoviesRemoteImp(mService,mMoviesMapper,mDetailedMoviesMapper,mGenresMapper);
//    }

    @Binds
    abstract MoviesRemote bindMoviesRemote(MoviesRemoteImp mRemoteImp);
}
