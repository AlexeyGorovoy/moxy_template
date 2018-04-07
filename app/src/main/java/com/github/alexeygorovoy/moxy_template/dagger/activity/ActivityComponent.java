package com.github.alexeygorovoy.moxy_template.dagger.activity;

import com.github.alexeygorovoy.moxy_template.dagger.demo.details.HeroDetailsComponent;
import com.github.alexeygorovoy.moxy_template.dagger.demo.details.HeroDetailsModule;
import com.github.alexeygorovoy.moxy_template.dagger.demo.heroes.HeroesComponent;
import com.github.alexeygorovoy.moxy_template.dagger.demo.heroes.HeroesModule;
import com.github.alexeygorovoy.moxy_template.dagger.demo.splash.SplashComponent;
import com.github.alexeygorovoy.moxy_template.dagger.demo.splash.SplashModule;
import com.github.alexeygorovoy.moxy_template.ui.common.BaseActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    SplashComponent plus(SplashModule module);

    HeroesComponent plus(HeroesModule module);

    HeroDetailsComponent plus(HeroDetailsModule module);

    void inject(BaseActivity baseActivity);
}
