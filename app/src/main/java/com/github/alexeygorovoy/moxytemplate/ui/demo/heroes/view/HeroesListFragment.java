package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.alexeygorovoy.moxytemplate.R;
import com.github.alexeygorovoy.moxytemplate.api.models.Hero;
import com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes.HeroesModule;
import com.github.alexeygorovoy.moxytemplate.navigation.Router;
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpFragment;
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter.HeroesListPresenter;
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter.HeroesAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;

public class HeroesListFragment extends BaseMvpFragment implements HeroesListView {

    @Inject
    Router router;

    @Inject
    @InjectPresenter
    HeroesListPresenter presenter;

    @ProvidePresenter
    HeroesListPresenter providePresenter() {
        return presenter;
    }

    @BindView(R.id.heroes_list)
    RecyclerView list;

    @BindView(R.id.progress_bar)
    ContentLoadingProgressBar progressBar;

    private HeroesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivityComponent().plus(new HeroesModule()).inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_heroes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        adapter = new HeroesAdapter();

        Subscription sub = adapter.onHeroClickedObservable()
                .subscribe(
                        hero -> router.openHeroDetails(getBaseActivity(), hero)
                );
        unsubscribeOnDestroyView(sub);

        list.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(requireContext());
        list.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showHeroes(List<Hero> heroes) {
        adapter.setItems(heroes);
    }

    @Override
    public void showProgress() {
        progressBar.show();
    }

    @Override
    public void hideProgress() {
        progressBar.hide();
    }

    public static HeroesListFragment newInstance() {

        Bundle args = new Bundle();

        HeroesListFragment fragment = new HeroesListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
