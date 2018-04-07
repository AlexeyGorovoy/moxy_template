package com.github.alexeygorovoy.moxy_template.dagger.demo.splash;

import com.github.alexeygorovoy.moxy_template.ui.demo.splash.presenter.SplashPresenter;
import com.github.alexeygorovoy.moxy_template.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;


@Module
public class SplashModule {

    @Provides
    SplashPresenter provideSplashPresenter(RxSchedulers schedulers) {
        return new SplashPresenter(schedulers);
    }

}

