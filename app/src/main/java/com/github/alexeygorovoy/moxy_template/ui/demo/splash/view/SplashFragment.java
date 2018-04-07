package com.github.alexeygorovoy.moxy_template.ui.demo.splash.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.alexeygorovoy.moxy_template.R;
import com.github.alexeygorovoy.moxy_template.dagger.demo.splash.SplashModule;
import com.github.alexeygorovoy.moxy_template.navigation.Router;
import com.github.alexeygorovoy.moxy_template.ui.common.BaseActivity;
import com.github.alexeygorovoy.moxy_template.ui.common.moxy.BaseMvpFragment;
import com.github.alexeygorovoy.moxy_template.ui.demo.splash.presenter.SplashPresenter;

import javax.inject.Inject;

public class SplashFragment extends BaseMvpFragment implements SplashView {

    @Inject
    Router router;

    @Inject
    @InjectPresenter
    SplashPresenter splashPresenter;

    @ProvidePresenter
    SplashPresenter providePresenter() {
        return splashPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivityComponent().plus(new SplashModule()).inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void openHeroesScreen() {
        BaseActivity activity = getBaseActivity();
        router.startMainActivity(activity);
        activity.finish();
    }
}
