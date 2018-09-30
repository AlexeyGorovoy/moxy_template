package com.github.alexeygorovoy.moxytemplate.ui.demo.details.view

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpView

interface HeroDetailsView : BaseMvpView {

    @StateStrategyType(SingleStateStrategy::class)
    fun showHero(hero: Hero)
}
