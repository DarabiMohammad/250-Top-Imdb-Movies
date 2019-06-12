package com.mohammad.domain.interactor;

import com.mohammad.domain.executer.PostExecutionThread;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class CompletableUseCase<Params> {

    private PostExecutionThread mPostExecutionThread;
    private CompositeDisposable mDisposables;

    public abstract Completable buildCompletableUseCase(Params mParams);

    public void execute(DisposableCompletableObserver mObserver,Params mParams){
        Completable mCompletable = buildCompletableUseCase(mParams)
                .subscribeOn(Schedulers.io())
                .observeOn(mPostExecutionThread.getScheduler());
    }

    public void dispose(){
        if(mDisposables != null)
            mDisposables.dispose();
    }

    private void addDisposable(Disposable mDisposable){
        if(mDisposable != null && mDisposables != null)
            mDisposables.add(mDisposable);
    }
}
