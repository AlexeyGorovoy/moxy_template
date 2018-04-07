package com.github.alexeygorovoy.moxy_template.ui.common.moxy;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseMvpView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showInfoToast(@NonNull CharSequence message);

    @StateStrategyType(SkipStrategy.class)
    void showErrorToast(@NonNull CharSequence message);

    @StateStrategyType(SkipStrategy.class)
    void showSuccessToast(@NonNull CharSequence message);
}
