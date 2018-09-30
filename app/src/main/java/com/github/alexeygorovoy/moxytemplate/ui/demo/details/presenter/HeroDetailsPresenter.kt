package com.github.alexeygorovoy.moxytemplate.ui.demo.details.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.view.HeroDetailsView

@InjectViewState
class HeroDetailsPresenter : BaseMvpPresenter<HeroDetailsView>() {

    private lateinit var hero: Hero

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showHero(hero)
    }

    fun setHero(hero: Hero) {
        this.hero = hero
    }
}
