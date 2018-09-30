package com.github.alexeygorovoy.moxytemplate.dagger.app

import com.github.alexeygorovoy.moxytemplate.api.HeroApi
import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityModule
import com.github.alexeygorovoy.moxytemplate.utils.rx.RxSchedulers

import dagger.Component

@AppScope
@Component(modules = [NetworkModule::class, AppContextModule::class, UtilsModule::class])
interface AppComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent

    fun rxSchedulers(): RxSchedulers

    fun apiService(): HeroApi
}
