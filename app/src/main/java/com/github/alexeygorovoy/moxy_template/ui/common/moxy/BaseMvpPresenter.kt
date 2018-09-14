package com.github.alexeygorovoy.moxy_template.ui.common.moxy

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

import rx.Observable
import rx.Subscription
import rx.subscriptions.CompositeSubscription

abstract class BaseMvpPresenter<View : MvpView> : MvpPresenter<View>() {

    private val subscriptions = CompositeSubscription()

    protected fun <T> progressTransformer(): Observable.Transformer<T, T> {
        return Observable.Transformer { it ->
            it.doOnSubscribe {
                (viewState as? MvpProgressView)?.showProgress()
            }.doOnTerminate {
                (viewState as? MvpProgressView)?.hideProgress()
            }
        }
    }

    protected fun unsubscribeOnDestroy(sub: Subscription) {
        subscriptions.add(sub)
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
        super.onDestroy()
    }
}
