package com.github.alexeygorovoy.moxy_template.ui.demo.heroes.view.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView.ViewHolder
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.github.alexeygorovoy.moxy_template.R
import com.github.alexeygorovoy.moxy_template.api.models.Hero

import butterknife.BindView
import butterknife.ButterKnife
import rx.subjects.PublishSubject

class HeroViewHolder internal constructor(itemView: View, private val clickSubject: PublishSubject<Hero>) : ViewHolder(itemView) {

    @BindView(R.id.item_hero_image)
    lateinit var imageHero: ImageView

    @BindView(R.id.item_hero_name)
    lateinit var nameHero: TextView

    @BindView(R.id.item_hero_year)
    lateinit var dateReleaseHero: TextView

    @BindView(R.id.item_hero_separator)
    lateinit var separatorHero: View

    @BindView(R.id.item_hero_text)
    lateinit var descriptionHero: TextView

    init {
        ButterKnife.bind(this, itemView)
    }

    internal fun bind(hero: Hero) {
        Glide.with(itemView.context)
            .load(hero.image)
            .into(imageHero)

        nameHero.text = if (TextUtils.isEmpty(hero.title)) "missing title" else hero.title
        dateReleaseHero.text = if (TextUtils.isEmpty(hero.year)) "missing year" else hero.year
        descriptionHero.text = if (TextUtils.isEmpty(hero.intro)) "missing text" else hero.intro
        separatorHero.setBackgroundColor(Color.parseColor(hero.color))

        itemView.setOnClickListener { _ -> clickSubject.onNext(hero) }
    }
}
