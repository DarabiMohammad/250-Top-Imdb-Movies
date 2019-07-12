package com.mohammad.ui.injection.module;

import com.mohammad.domain.executer.PostExecutionThread;
import com.mohammad.ui.UiThread;
import com.mohammad.ui.browse.activity.BrowseActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UiModule {

    @Binds
    abstract PostExecutionThread bindPostExecutionThread(UiThread mUiThread);

    @ContributesAndroidInjector
    abstract BrowseActivity contributesAndroidInjector();
}
