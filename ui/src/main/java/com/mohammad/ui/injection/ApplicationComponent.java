package com.mohammad.ui.injection;

import android.app.Application;

import com.mohammad.ui.MoviesApplication;
import com.mohammad.ui.injection.module.ApplicationModule;
import com.mohammad.ui.injection.module.CacheModule;
import com.mohammad.ui.injection.module.DataModule;
import com.mohammad.ui.injection.module.PresentationModule;
import com.mohammad.ui.injection.module.UiModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class,
        UiModule.class, PresentationModule.class, DataModule.class, CacheModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application mApplication);

        ApplicationComponent build();
    }

    @Override
    void inject(DaggerApplication instance);

    void inject(MoviesApplication mMoviesApplication);
}
