package com.github.alexeygorovoy.moxy_template.dagger.demo.heroes

import com.github.alexeygorovoy.moxy_template.api.HeroApi
import com.github.alexeygorovoy.moxy_template.ui.demo.heroes.presenter.HeroesListPresenter
import com.github.alexeygorovoy.moxy_template.utils.rx.RxSchedulers

import dagger.Module
import dagger.Provides

@Module
class HeroesModule {

    @Provides
    internal fun provideHeroesListPresenter(heroApi: HeroApi, rxSchedulers: RxSchedulers) = HeroesListPresenter(heroApi, rxSchedulers)
}
