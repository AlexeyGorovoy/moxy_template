package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.github.alexeygorovoy.moxytemplate.api.HeroApi;
import com.github.alexeygorovoy.moxytemplate.api.models.Hero;
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpPresenter;
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.HeroesListView;
import com.github.alexeygorovoy.moxytemplate.rx.RxSchedulers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import rx.Subscription;
import timber.log.Timber;

@InjectViewState
public class HeroesListPresenter extends BaseMvpPresenter<HeroesListView> {

    private final HeroApi heroApi;
    private final RxSchedulers rxSchedulers;
    private final ArrayList<Hero> heroes = new ArrayList<>();

    public HeroesListPresenter(HeroApi heroApi, RxSchedulers schedulers) {
        this.heroApi = heroApi;
        this.rxSchedulers = schedulers;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadHeroesList();
    }

    private void loadHeroesList() {
        Subscription sub = heroApi.getHeroes()
                .delay(500, TimeUnit.MILLISECONDS)
                .compose(rxSchedulers.ioToMain())
                .compose(progressTransformer())
                .subscribe(
                        result -> {
                            heroes.clear();
                            heroes.addAll(result.getElements());
                            getViewState().showHeroes(heroes);
                        },
                        throwable -> Timber.e(throwable, "Error loading heroes list!")
                );
        unsubscribeOnDestroy(sub);
    }
}
