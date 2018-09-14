package com.github.alexeygorovoy.moxy_template.dagger.demo.splash

import com.github.alexeygorovoy.moxy_template.ui.demo.splash.presenter.SplashPresenter
import com.github.alexeygorovoy.moxy_template.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    internal fun provideSplashPresenter(schedulers: RxSchedulers) = SplashPresenter(schedulers)
}

