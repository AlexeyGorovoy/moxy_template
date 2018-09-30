package com.github.alexeygorovoy.moxytemplate.ui.demo.splash.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.moxytemplate.ui.demo.splash.view.SplashView
import com.github.alexeygorovoy.moxytemplate.utils.rx.RxSchedulers
import rx.Single
import timber.log.Timber
import java.util.concurrent.TimeUnit

@InjectViewState
class SplashPresenter(private val rxSchedulers: RxSchedulers) : BaseMvpPresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        // real loading will happen here if needed
        Single.just("")
            .delay(500, TimeUnit.MILLISECONDS)
            .compose(rxSchedulers.computationToMainSingle())
            .subscribe(
                {
                    viewState.showSuccessToast("App started!")
                    viewState.openHeroesScreen()
                },
                { throwable -> Timber.e(throwable, "error on splash!") }
            )
            .unsubscribeOnDestroy()
    }
}
