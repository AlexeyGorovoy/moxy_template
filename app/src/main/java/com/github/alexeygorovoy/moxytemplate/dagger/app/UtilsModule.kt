package com.github.alexeygorovoy.moxytemplate.dagger.app

import com.github.alexeygorovoy.moxytemplate.navigation.Router
import com.github.alexeygorovoy.moxytemplate.utils.rx.AppRxSchedulers
import com.github.alexeygorovoy.moxytemplate.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()

    @Provides
    internal fun provideRouter(): Router = Router()
}
