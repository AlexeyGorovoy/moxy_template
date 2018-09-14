package com.github.alexeygorovoy.moxy_template.dagger.demo.splash

import com.github.alexeygorovoy.moxy_template.ui.demo.splash.view.SplashFragment

import dagger.Subcomponent

@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {
    fun inject(fragment: SplashFragment)
}
