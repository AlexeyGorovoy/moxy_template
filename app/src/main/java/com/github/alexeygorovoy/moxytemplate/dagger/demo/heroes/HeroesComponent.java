package com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes;

import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.HeroesListFragment;

import dagger.Subcomponent;


@Subcomponent(modules = {HeroesModule.class})
public interface HeroesComponent {

    void inject(HeroesListFragment fragment);
}
