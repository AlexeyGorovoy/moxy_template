package com.github.alexeygorovoy.moxytemplate.ui.demo.details;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.github.alexeygorovoy.moxytemplate.api.models.Hero;
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpPresenter;
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.view.HeroDetailsView;

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
