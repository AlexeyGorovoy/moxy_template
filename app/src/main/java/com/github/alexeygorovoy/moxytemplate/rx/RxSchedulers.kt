package com.github.alexeygorovoy.moxytemplate.utils.rx

import rx.Completable
import rx.Observable
import rx.Scheduler
import rx.Single

abstract class RxSchedulers {

    abstract fun mainThread(): Scheduler

    abstract fun io(): Scheduler

    abstract fun computation(): Scheduler

    fun <T> ioToMain(): Observable.Transformer<T, T> {
        return Observable.Transformer { objectObservable ->
            objectObservable
                .subscribeOn(io())
                .observeOn(mainThread())
        }
    }

    fun ioToMainCompletable(): Completable.Transformer {
        return Completable.Transformer { completable ->
            completable
                .subscribeOn(io())
                .observeOn(mainThread())
        }
    }

    fun <T> ioToMainSingle(): Single.Transformer<T, T> {
        return Single.Transformer { objectObservable ->
            objectObservable
                .subscribeOn(io())
                .observeOn(mainThread())
        }
    }

    fun <T> computationToMain(): Observable.Transformer<T, T> {
        return Observable.Transformer { objectObservable ->
            objectObservable
                .subscribeOn(computation())
                .observeOn(mainThread())
        }
    }

    fun <T> computationToMainSingle(): Single.Transformer<T, T> {
        return Single.Transformer { objectObservable ->
            objectObservable
                .subscribeOn(computation())
                .observeOn(mainThread())
        }
    }
}
