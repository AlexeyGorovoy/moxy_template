package com.github.alexeygorovoy.moxy_template.utils.rx;

import rx.Completable;
import rx.Observable;
import rx.Scheduler;
import rx.Single;


public abstract class RxSchedulers {


    abstract public Scheduler mainThread();

    abstract public Scheduler io();

    abstract public Scheduler computation();

    public <T> Observable.Transformer<T, T> ioToMain() {
        return objectObservable -> objectObservable
                .subscribeOn(io())
                .observeOn(mainThread());
    }

    public Completable.Transformer ioToMainCompletable() {
        return completable -> completable
                .subscribeOn(io())
                .observeOn(mainThread());
    }

    public <T> Single.Transformer<T, T> ioToMainSingle() {
        return objectObservable -> objectObservable
                .subscribeOn(io())
                .observeOn(mainThread());
    }

    public <T> Observable.Transformer<T, T> computationToMain() {
        return objectObservable -> objectObservable
                .subscribeOn(computation())
                .observeOn(mainThread());
    }

    public <T> Single.Transformer<T, T> computationToMainSingle() {
        return objectObservable -> objectObservable
                .subscribeOn(computation())
                .observeOn(mainThread());
    }
}
