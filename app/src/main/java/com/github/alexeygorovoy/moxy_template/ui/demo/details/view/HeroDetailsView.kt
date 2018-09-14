package com.github.alexeygorovoy.moxy_template.ui.demo.details.view

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.alexeygorovoy.moxy_template.api.models.Hero
import com.github.alexeygorovoy.moxy_template.ui.common.moxy.BaseMvpView

interface HeroDetailsView : BaseMvpView {

    @StateStrategyType(SingleStateStrategy::class)
    fun showHero(hero: Hero)
}
