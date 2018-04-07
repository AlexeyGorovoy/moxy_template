package com.github.alexeygorovoy.moxy_template.ui.common.moxy;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseMvpPresenter<View extends MvpView> extends MvpPresenter<View> {

    private final CompositeSubscription subscriptions = new CompositeSubscription();

    protected <T> Observable.Transformer<T, T> progressTransformer() {
        return it -> it.doOnSubscribe(
                () -> {
                    if (getViewState() instanceof MvpProgressView) {
                        ((MvpProgressView) getViewState()).showProgress();
                    }
                }
        ).doOnTerminate(
                () -> {
                    if (BaseMvpPresenter.this.getViewState() instanceof MvpProgressView) {
                        ((MvpProgressView) BaseMvpPresenter.this.getViewState()).hideProgress();
                    }
                }
        );
    }

    protected void unsubscribeOnDestroy(Subscription sub) {
        subscriptions.add(sub);
    }

    @Override
    public void onDestroy() {
        subscriptions.unsubscribe();
        super.onDestroy();
    }

}
