package com.github.alexeygorovoy.moxy_template.dagger.app

import com.github.alexeygorovoy.moxy_template.api.HeroApi
import com.github.alexeygorovoy.moxy_template.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.moxy_template.dagger.activity.ActivityModule
import com.github.alexeygorovoy.moxy_template.utils.rx.RxSchedulers

import dagger.Component

@AppScope
@Component(modules = [NetworkModule::class, AppContextModule::class, UtilsModule::class])
interface AppComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent

    fun rxSchedulers(): RxSchedulers

    fun apiService(): HeroApi
}
