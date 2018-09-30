package com.github.alexeygorovoy.moxytemplate.ui.common.moxy

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface MvpProgressView : MvpView {

    @StateStrategyType(value = AddToEndSingleTagStrategy::class, tag = PROGRESS_TAG)
    fun showProgress()

    @StateStrategyType(value = AddToEndSingleTagStrategy::class, tag = PROGRESS_TAG)
    fun hideProgress()

    companion object {

        private const val PROGRESS_TAG = "PROGRESS_TAG"
    }
}
