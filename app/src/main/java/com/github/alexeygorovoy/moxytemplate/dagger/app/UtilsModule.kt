package com.github.alexeygorovoy.moxytemplate.dagger.app

import com.github.alexeygorovoy.moxytemplate.rx.AppRxSchedulers
import com.github.alexeygorovoy.moxytemplate.rx.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()
}
