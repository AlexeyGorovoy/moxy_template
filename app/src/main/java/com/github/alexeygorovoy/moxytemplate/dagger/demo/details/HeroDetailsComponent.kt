package com.github.alexeygorovoy.moxytemplate.dagger.demo.details

import com.github.alexeygorovoy.moxytemplate.ui.demo.details.view.HeroDetailsFragment

import dagger.Subcomponent

@Subcomponent(modules = [HeroDetailsModule::class])
interface HeroDetailsComponent {
    fun inject(fragment: HeroDetailsFragment)
}
