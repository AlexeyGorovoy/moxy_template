package com.github.alexeygorovoy.moxytemplate.dagger.activity

import com.github.alexeygorovoy.moxytemplate.dagger.demo.details.HeroDetailsComponent
import com.github.alexeygorovoy.moxytemplate.dagger.demo.details.HeroDetailsModule
import com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes.HeroesComponent
import com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes.HeroesModule
import com.github.alexeygorovoy.moxytemplate.dagger.demo.splash.SplashComponent
import com.github.alexeygorovoy.moxytemplate.dagger.demo.splash.SplashModule
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity
import com.github.alexeygorovoy.moxytemplate.ui.common.MainActivity

import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    operator fun plus(module: SplashModule): SplashComponent
    operator fun plus(module: HeroesModule): HeroesComponent
    operator fun plus(module: HeroDetailsModule): HeroDetailsComponent

    fun inject(baseActivity: BaseActivity)
    fun inject(baseActivity: MainActivity)

}
