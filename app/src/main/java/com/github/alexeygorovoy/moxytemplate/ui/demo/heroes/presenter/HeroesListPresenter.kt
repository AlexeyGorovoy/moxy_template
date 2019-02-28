package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter

import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.HeroesListView

abstract class HeroesListPresenter : BaseMvpPresenter<HeroesListView>() {
    abstract fun onHeroClicked(hero: Hero)
}
