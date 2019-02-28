package com.github.alexeygorovoy.moxytemplate.ui.demo.splash.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.moxytemplate.navigation.Router
import com.github.alexeygorovoy.moxytemplate.rx.RxSchedulers
import rx.Single
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class SplashPresenterImpl @Inject internal constructor(
    private val rxSchedulers: RxSchedulers,
    private val router: Router
) : SplashPresenter() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        // real loading will happen here if needed
        Single.just("")
            .delay(500, TimeUnit.MILLISECONDS)
            .compose(rxSchedulers.computationToMainSingle())
            .subscribe(
                {
                    router.openHeroListScreen()
                },
                { throwable -> Timber.e(throwable, "error on splash!") }
            )
            .unsubscribeOnDestroy()
    }
}
