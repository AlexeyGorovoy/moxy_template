package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import java.util.ArrayList

class HeroesAdapter(private val onClickListener: (hero: Hero) -> Unit) : RecyclerView.Adapter<HeroViewHolder>() {

    private val listHeroes = ArrayList<Hero>()

    fun setItems(heroes: List<Hero>) {
        this.listHeroes.clear()
        this.listHeroes.addAll(heroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return HeroViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = listHeroes[position]
        holder.bind(hero)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }
}
