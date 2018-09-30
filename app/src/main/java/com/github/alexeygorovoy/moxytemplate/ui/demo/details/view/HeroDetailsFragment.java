package com.github.alexeygorovoy.moxytemplate.ui.demo.details.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.github.alexeygorovoy.moxytemplate.R;
import com.github.alexeygorovoy.moxytemplate.api.models.Hero;
import com.github.alexeygorovoy.moxytemplate.dagger.demo.details.HeroDetailsModule;
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpFragment;
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.HeroDetailsPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HeroDetailsFragment extends BaseMvpFragment implements HeroDetailsView {

    private static final String ARG_HERO = "arg_hero";

    @Inject
    @InjectPresenter
    HeroDetailsPresenter presenter;

    @ProvidePresenter
    HeroDetailsPresenter providePresenter() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Hero hero = (Hero) arguments.getSerializable(ARG_HERO);
            if (hero != null) {
                presenter.setHero(hero);
            } else {
                Timber.e("No hero provided!");
            }
        }
        return presenter;
    }

    @BindView(R.id.hero_image)
    ImageView imageHero;

    @BindView(R.id.hero_intro)
    TextView introduction;

    @BindView(R.id.hero_text)
    TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivityComponent().plus(new HeroDetailsModule()).inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hero_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @Override
    public void showHero(Hero hero) {
        Glide.with(requireContext()).load(hero.getImage()).into(imageHero);
        introduction.setText(TextUtils.isEmpty(hero.getIntro()) ? "no intro" : hero.getIntro());
        text.setText(TextUtils.isEmpty(hero.getText()) ? "no text" : hero.getText());
    }

    public static HeroDetailsFragment newInstance(Hero hero) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_HERO, hero);

        HeroDetailsFragment fragment = new HeroDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
