package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.alexeygorovoy.moxytemplate.api.models.Hero;
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpView;
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.MvpProgressView;

import java.util.List;

public interface HeroesListView extends BaseMvpView, MvpProgressView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showHeroes(List<Hero> heroes);

}
