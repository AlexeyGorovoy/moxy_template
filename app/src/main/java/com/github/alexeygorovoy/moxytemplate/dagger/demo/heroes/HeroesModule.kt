package com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes

import com.github.alexeygorovoy.moxytemplate.api.HeroApi
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter.HeroesListPresenter
import com.github.alexeygorovoy.moxytemplate.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class HeroesModule {

    @Provides
    internal fun provideHeroesListPresenter(heroApi: HeroApi, rxSchedulers: RxSchedulers) = HeroesListPresenter(heroApi, rxSchedulers)
}
