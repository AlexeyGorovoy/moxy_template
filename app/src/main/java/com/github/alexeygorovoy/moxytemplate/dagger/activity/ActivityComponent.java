package com.github.alexeygorovoy.moxytemplate.dagger.activity;

import com.github.alexeygorovoy.moxytemplate.dagger.demo.details.HeroDetailsComponent;
import com.github.alexeygorovoy.moxytemplate.dagger.demo.details.HeroDetailsModule;
import com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes.HeroesComponent;
import com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes.HeroesModule;
import com.github.alexeygorovoy.moxytemplate.dagger.demo.splash.SplashComponent;
import com.github.alexeygorovoy.moxytemplate.dagger.demo.splash.SplashModule;
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    SplashComponent plus(SplashModule module);

    HeroesComponent plus(HeroesModule module);

    HeroDetailsComponent plus(HeroDetailsModule module);

    void inject(BaseActivity baseActivity);
}
