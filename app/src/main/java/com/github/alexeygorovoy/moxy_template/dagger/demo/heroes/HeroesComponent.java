package com.github.alexeygorovoy.moxy_template.dagger.demo.heroes;

import com.github.alexeygorovoy.moxy_template.ui.demo.heroes.view.HeroesListFragment;

import dagger.Subcomponent;


@Subcomponent(modules = {HeroesModule.class})
public interface HeroesComponent {

    void inject(HeroesListFragment fragment);
}
