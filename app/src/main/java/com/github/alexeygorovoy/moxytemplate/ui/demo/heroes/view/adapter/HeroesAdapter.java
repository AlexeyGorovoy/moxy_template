package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.alexeygorovoy.moxytemplate.R;
import com.github.alexeygorovoy.moxytemplate.api.models.Hero;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;


public class HeroesAdapter extends RecyclerView.Adapter<HeroViewHolder> {

    private final PublishSubject<Hero> itemClicks = PublishSubject.create();
    private final ArrayList<Hero> listHeroes = new ArrayList<>();

    public void setItems(List<Hero> heroes) {
        this.listHeroes.clear();
        this.listHeroes.addAll(heroes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new HeroViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = listHeroes.get(position);
        holder.bind(hero);
    }


    @Override
    public int getItemCount() {
        return listHeroes.size();
    }

    public Observable<Hero> onHeroClickedObservable() {
        return itemClicks.asObservable();
    }
}
