package com.github.alexeygorovoy.moxytemplate.dagger.app;

import com.github.alexeygorovoy.moxytemplate.navigation.Router;
import com.github.alexeygorovoy.moxytemplate.rx.AppRxSchedulers;
import com.github.alexeygorovoy.moxytemplate.rx.RxSchedulers;

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
