package com.github.alexeygorovoy.moxytemplate.ui.demo.details.view;

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.alexeygorovoy.moxytemplate.api.models.Hero;
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpView;

public interface HeroDetailsView extends BaseMvpView {

    @StateStrategyType(SingleStateStrategy.class)
    void showHero(Hero hero);
}
