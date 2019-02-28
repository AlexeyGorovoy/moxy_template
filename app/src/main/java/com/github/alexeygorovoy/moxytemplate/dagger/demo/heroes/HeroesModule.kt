package com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes

import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter.HeroesListPresenter
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter.HeroesListPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class HeroesModule {

    @Provides
    internal fun provideHeroesListPresenter(presenter: HeroesListPresenterImpl): HeroesListPresenter = presenter
}
