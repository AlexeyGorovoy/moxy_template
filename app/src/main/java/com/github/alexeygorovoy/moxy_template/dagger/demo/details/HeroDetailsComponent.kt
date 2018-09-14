package com.github.alexeygorovoy.moxy_template.dagger.demo.details

import com.github.alexeygorovoy.moxy_template.ui.demo.details.view.HeroDetailsFragment

import dagger.Subcomponent

@Subcomponent(modules = [HeroDetailsModule::class])
interface HeroDetailsComponent {
    fun inject(fragment: HeroDetailsFragment)
}
