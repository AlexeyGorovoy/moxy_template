package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import rx.Observable
import rx.subjects.PublishSubject
import java.util.ArrayList

class HeroesAdapter : RecyclerView.Adapter<HeroViewHolder>() {

    private val itemClicks = PublishSubject.create<Hero>()
    private val listHeroes = ArrayList<Hero>()

    fun setItems(heroes: List<Hero>) {
        this.listHeroes.clear()
        this.listHeroes.addAll(heroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroViewHolder(view, itemClicks)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = listHeroes[position]
        holder.bind(hero)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    fun onHeroClickedObservable(): Observable<Hero> {
        return itemClicks.asObservable()
    }
}
