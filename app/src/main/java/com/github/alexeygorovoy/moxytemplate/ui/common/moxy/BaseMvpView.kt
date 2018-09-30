package com.github.alexeygorovoy.moxytemplate.ui.common.moxy

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseMvpView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun showInfoToast(message: CharSequence)

    @StateStrategyType(SkipStrategy::class)
    fun showErrorToast(message: CharSequence)

    @StateStrategyType(SkipStrategy::class)
    fun showSuccessToast(message: CharSequence)
}
