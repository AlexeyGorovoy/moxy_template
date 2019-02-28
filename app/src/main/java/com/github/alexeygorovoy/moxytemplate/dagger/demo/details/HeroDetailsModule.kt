package com.github.alexeygorovoy.moxytemplate.dagger.demo.details

import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.presenter.HeroDetailsPresenter
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.presenter.HeroDetailsPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class HeroDetailsModule(private val hero: Hero) {

    @Provides
    internal fun heroDetailsPresenter(presenter: HeroDetailsPresenterImpl): HeroDetailsPresenter = presenter

    @Provides
    internal fun provideHero(): Hero = hero
}
