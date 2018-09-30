package com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes;

import com.github.alexeygorovoy.moxytemplate.api.HeroApi;
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter.HeroesListPresenter;
import com.github.alexeygorovoy.moxytemplate.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;


@Module
public class HeroesModule {

    @Provides
    HeroesListPresenter provideHeroesListPresenter(HeroApi heroApi, RxSchedulers rxSchedulers) {
        return new HeroesListPresenter(heroApi, rxSchedulers);
    }


}
