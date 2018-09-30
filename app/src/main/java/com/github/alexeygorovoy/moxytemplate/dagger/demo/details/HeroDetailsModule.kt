package com.github.alexeygorovoy.moxytemplate.dagger.demo.details

import com.github.alexeygorovoy.moxytemplate.ui.demo.details.presenter.HeroDetailsPresenter

import dagger.Module
import dagger.Provides

@Module
class HeroDetailsModule {

    @Provides
    internal fun heroDetailsPresenter(): HeroDetailsPresenter = HeroDetailsPresenter()
}
