package com.github.alexeygorovoy.moxytemplate.ui.common.moxy

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import rx.Completable

import rx.Observable
import rx.Single
import rx.Subscription
import rx.subscriptions.CompositeSubscription

abstract class BaseMvpPresenter<View : MvpView> : MvpPresenter<View>() {

    private val subscriptions = CompositeSubscription()

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


    protected fun Subscription.unsubscribeOnDestroy() {
        subscriptions.add(this)
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
        super.onDestroy()
    }
}
