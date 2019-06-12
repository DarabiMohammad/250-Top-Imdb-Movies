package com.mohammad.domain.interactor;

import com.mohammad.domain.executer.PostExecutionThread;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class ObservableUseCase<T, Params> {

    private PostExecutionThread mPostExecutionThread;
    private CompositeDisposable mDisposables;

    public ObservableUseCase(PostExecutionThread mPostExecutionThread) {
        this.mPostExecutionThread = mPostExecutionThread;
        mDisposables = new CompositeDisposable();
    }

    public abstract Observable<T> buildObservableUseCase(Params mParams);

    public void execute(DisposableObserver<T> mObserver, Params mParams) {
        Observable<T> mObservable = buildObservableUseCase(mParams)
                .subscribeOn(Schedulers.io())
                .observeOn(mPostExecutionThread.getScheduler());
        addDisposable(mObservable.subscribeWith(mObserver));
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
