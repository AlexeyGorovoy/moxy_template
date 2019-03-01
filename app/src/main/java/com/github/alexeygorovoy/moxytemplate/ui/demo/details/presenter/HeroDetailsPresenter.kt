package com.github.alexeygorovoy.moxytemplate.ui.demo.details.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpPresenter
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.view.HeroDetailsView
import javax.inject.Inject

@InjectViewState
class HeroDetailsPresenter @Inject internal constructor(
    private val hero: Hero
) : BaseMvpPresenter<HeroDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showHero(hero)
    }
}
