package com.github.alexeygorovoy.moxy_template.dagger.app;

import com.github.alexeygorovoy.moxy_template.navigation.Router;
import com.github.alexeygorovoy.moxy_template.utils.rx.AppRxSchedulers;
import com.github.alexeygorovoy.moxy_template.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;


@Module
public class UtilsModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }

    @Provides
    Router provideRouter() {
        return new Router();
    }
}
