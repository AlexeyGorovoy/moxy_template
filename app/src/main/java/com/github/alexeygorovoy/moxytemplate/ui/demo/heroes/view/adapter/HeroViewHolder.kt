package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter

import android.graphics.Color
import android.text.TextUtils
import android.view.View
import com.bumptech.glide.Glide
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.ui.common.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_hero.*
import rx.subjects.PublishSubject

class HeroViewHolder (itemView: View, private val clickSubject: PublishSubject<Hero>) : BaseViewHolder(itemView) {

    internal fun bind(hero: Hero) {
        Glide.with(itemView.context)
            .load(hero.image)
            .into(itemHeroImage)

        itemHeroName.text = if (TextUtils.isEmpty(hero.title)) "missing title" else hero.title
        itemHeroYear.text = if (TextUtils.isEmpty(hero.year)) "missing year" else hero.year
        itemHeroText.text = if (TextUtils.isEmpty(hero.intro)) "missing text" else hero.intro
        itemHeroSeparator.setBackgroundColor(Color.parseColor(hero.color))

        itemView.setOnClickListener { _ -> clickSubject.onNext(hero) }
    }
}
