package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter

import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class HeroesAdapter(
    onClickListener: (hero: Hero) -> Unit
) : ListDelegationAdapter<List<Hero>>() {

    init {
        delegatesManager.addDelegate(HeroAdapterDelegate(onClickListener))
    }

    override fun setItems(items: List<Hero>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}
