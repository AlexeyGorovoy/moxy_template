package com.github.alexeygorovoy.moxytemplate.dagger.demo.details;

import com.github.alexeygorovoy.moxytemplate.ui.demo.details.HeroDetailsPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class HeroDetailsModule {

    @Provides
    HeroDetailsPresenter heroDetailsPresenter() {
        return new HeroDetailsPresenter();
    }

}
