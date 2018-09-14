package com.github.alexeygorovoy.moxy_template.dagger.app

import com.github.alexeygorovoy.moxy_template.navigation.Router
import com.github.alexeygorovoy.moxy_template.utils.rx.AppRxSchedulers
import com.github.alexeygorovoy.moxy_template.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()

    @Provides
    internal fun provideRouter(): Router = Router()
}
