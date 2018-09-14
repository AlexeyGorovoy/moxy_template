package com.github.alexeygorovoy.moxy_template.ui.demo.splash.view

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.alexeygorovoy.moxy_template.ui.common.moxy.BaseMvpView

interface SplashView : BaseMvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun openHeroesScreen()
}
