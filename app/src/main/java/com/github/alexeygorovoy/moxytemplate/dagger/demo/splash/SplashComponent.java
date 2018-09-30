package com.github.alexeygorovoy.moxytemplate.dagger.demo.splash;

import com.github.alexeygorovoy.moxytemplate.ui.demo.splash.view.SplashFragment;

import dagger.Subcomponent;


@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashFragment fragment);
}
