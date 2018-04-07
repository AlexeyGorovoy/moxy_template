package com.github.alexeygorovoy.moxy_template.dagger.demo.heroes;

import com.github.alexeygorovoy.moxy_template.api.HeroApi;
import com.github.alexeygorovoy.moxy_template.ui.demo.heroes.presenter.HeroesListPresenter;
import com.github.alexeygorovoy.moxy_template.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;


@Module
public class HeroesModule {

    @Provides
    HeroesListPresenter provideHeroesListPresenter(HeroApi heroApi, RxSchedulers rxSchedulers) {
        return new HeroesListPresenter(heroApi, rxSchedulers);
    }


}
