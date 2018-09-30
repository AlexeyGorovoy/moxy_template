package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.alexeygorovoy.moxytemplate.R;
import com.github.alexeygorovoy.moxytemplate.api.models.Hero;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.PublishSubject;


public class HeroViewHolder extends ViewHolder {

    private final PublishSubject<Hero> clickSubject;

    @BindView(R.id.item_hero_image)
    ImageView imageHero;

    @BindView(R.id.item_hero_name)
    TextView nameHero;

    @BindView(R.id.item_hero_year)
    TextView dateReleaseHero;

    @BindView(R.id.item_hero_separator)
    View separatorHero;

    @BindView(R.id.item_hero_text)
    TextView descriptionHero;

    HeroViewHolder(View itemView, @NonNull PublishSubject<Hero> clickSubject) {
        super(itemView);
        this.clickSubject = clickSubject;
        ButterKnife.bind(this, itemView);
    }

    void bind(Hero hero) {
        Glide.with(itemView.getContext())
                .load(hero.getImage())
                .into(imageHero);

        nameHero.setText(TextUtils.isEmpty(hero.getTitle()) ? "missing title" : hero.getTitle());
        dateReleaseHero.setText(TextUtils.isEmpty(hero.getYear()) ? "missing year" : hero.getYear());
        descriptionHero.setText(TextUtils.isEmpty(hero.getIntro()) ? "missing text" : hero.getIntro());
        separatorHero.setBackgroundColor(Color.parseColor(hero.getColor()));

        itemView.setOnClickListener(
                v -> clickSubject.onNext(hero)
        );
    }

}
