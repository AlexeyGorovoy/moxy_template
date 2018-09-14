package com.github.alexeygorovoy.moxy_template.dagger.demo.details

import com.github.alexeygorovoy.moxy_template.ui.demo.details.presenter.HeroDetailsPresenter

import dagger.Module
import dagger.Provides

@Module
class HeroDetailsModule {

    @Provides
    internal fun heroDetailsPresenter(): HeroDetailsPresenter = HeroDetailsPresenter()
}
