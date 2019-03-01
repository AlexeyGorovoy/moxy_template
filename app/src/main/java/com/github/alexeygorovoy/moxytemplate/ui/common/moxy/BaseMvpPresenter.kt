package com.github.alexeygorovoy.moxytemplate.ui.common.moxy

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseMvpPresenter<View : MvpView> : MvpPresenter<View>() {

    private val disposables = CompositeDisposable()

    protected fun <T> Observable<T>.progress(): Observable<T> {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    protected fun <T> Single<T>.progress(): Single<T> {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    protected fun Completable.progress(): Completable {
        return doOnSubscribe {
            showProgress()
        }.doAfterTerminate {
            hideProgress()
        }
    }

    protected fun showProgress() {
        (viewState as? MvpProgressView)?.showProgress()
    }

    protected fun hideProgress() {
        (viewState as? MvpProgressView)?.hideProgress()
    }


    protected fun Disposable.unsubscribeOnDestroy(): Disposable {
        disposables.add(this)
        return this
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}
