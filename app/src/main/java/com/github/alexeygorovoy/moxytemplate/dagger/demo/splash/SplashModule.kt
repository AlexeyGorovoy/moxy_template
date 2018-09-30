package com.github.alexeygorovoy.moxytemplate.dagger.demo.splash

import com.github.alexeygorovoy.moxytemplate.ui.demo.splash.presenter.SplashPresenter
import com.github.alexeygorovoy.moxytemplate.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    internal fun provideSplashPresenter(schedulers: RxSchedulers) = SplashPresenter(schedulers)
}

