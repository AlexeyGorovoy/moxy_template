package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HeroAdapterDelegate(private val onClickListener: (hero: Hero) -> Unit) : AbsListItemAdapterDelegate<Hero, Hero, HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return HeroViewHolder(view, onClickListener)
    }

    override fun isForViewType(item: Hero, items: MutableList<Hero>, position: Int): Boolean {
        return true
    }

    override fun onBindViewHolder(item: Hero, holder: HeroViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }
}