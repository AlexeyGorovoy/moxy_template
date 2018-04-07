package com.github.alexeygorovoy.moxy_template.ui.demo.details;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.github.alexeygorovoy.moxy_template.api.models.Hero;
import com.github.alexeygorovoy.moxy_template.ui.common.moxy.BaseMvpPresenter;
import com.github.alexeygorovoy.moxy_template.ui.demo.details.view.HeroDetailsView;

@InjectViewState
public class HeroDetailsPresenter extends BaseMvpPresenter<HeroDetailsView> {

    private Hero hero;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showHero(hero);
    }

    public void setHero(@NonNull Hero hero) {
        this.hero = hero;
    }
}
