package com.github.alexeygorovoy.moxytemplate.dagger.demo.splash;

import com.github.alexeygorovoy.moxytemplate.ui.demo.splash.presenter.SplashPresenter;
import com.github.alexeygorovoy.moxytemplate.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;


@Module
public class SplashModule {

    @Provides
    SplashPresenter provideSplashPresenter(RxSchedulers schedulers) {
        return new SplashPresenter(schedulers);
    }

}

