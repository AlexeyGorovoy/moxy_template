package com.github.alexeygorovoy.moxytemplate.ui.demo.splash.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpPresenter;
import com.github.alexeygorovoy.moxytemplate.ui.demo.splash.view.SplashView;
import com.github.alexeygorovoy.moxytemplate.rx.RxSchedulers;

import java.util.concurrent.TimeUnit;

import rx.Single;
import rx.Subscription;
import timber.log.Timber;


@InjectViewState
public class SplashPresenter extends BaseMvpPresenter<SplashView> {

    private final RxSchedulers rxSchedulers;

    public SplashPresenter(RxSchedulers schedulers) {
        this.rxSchedulers = schedulers;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        // real loading will happen here if needed
        Subscription sub = Single.just("")
                .delay(500, TimeUnit.MILLISECONDS)
                .compose(rxSchedulers.computationToMainSingle())
                .subscribe(
                        it -> {
                            getViewState().showSuccessToast("App started!");
                            getViewState().openHeroesScreen();
                        },
                        throwable -> Timber.e(throwable, "error on splash!")
                );
        unsubscribeOnDestroy(sub);
    }

}
