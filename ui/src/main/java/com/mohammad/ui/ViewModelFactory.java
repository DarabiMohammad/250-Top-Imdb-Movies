package com.mohammad.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> mViewModelFactory;

    @Inject
    ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> mViewModelFactory) {
        this.mViewModelFactory = mViewModelFactory;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<? extends ViewModel> mCreator = mViewModelFactory.get(modelClass);
        if (mCreator == null)
            for (Map.Entry<Class<? extends ViewModel>,Provider<ViewModel>> mModel : mViewModelFactory.entrySet()) {
                if (modelClass.isAssignableFrom(mModel.getKey())) {
                    mCreator = mModel.getValue();
                    break;
                }
            }
        if (mCreator == null)
            throw new IllegalArgumentException("unknown viewmodel ".concat(modelClass.getSimpleName()));
        try {
            return (T) mCreator.get();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
