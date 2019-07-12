package com.mohammad.ui;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.mohammad.ui.injection.ApplicationComponent;
import com.mohammad.ui.injection.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;

public class MoviesApplication extends DaggerApplication{

    @Inject
    public DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpTimber();
    }

    private void setUpTimber() {
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent mComponent = DaggerApplicationComponent.builder().application(this).build();
        mComponent.inject(this);
        return mComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
