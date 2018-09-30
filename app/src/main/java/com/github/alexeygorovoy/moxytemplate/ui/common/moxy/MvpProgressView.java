package com.github.alexeygorovoy.moxytemplate.ui.common.moxy;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface MvpProgressView extends MvpView {

    String PROGRESS_TAG = "PROGRESS_TAG";

    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = PROGRESS_TAG)
    void showProgress();

    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = PROGRESS_TAG)
    void hideProgress();
}
