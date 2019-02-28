package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.dagger.demo.heroes.HeroesModule
import com.github.alexeygorovoy.moxytemplate.navigation.Router
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpFragment
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter.HeroesListPresenter
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.adapter.HeroesAdapter
import kotlinx.android.synthetic.main.heroes_list_fragment.*
import javax.inject.Inject

class HeroesListFragment : BaseMvpFragment(), HeroesListView {

    @Inject
    lateinit var router: Router

    @Inject
    @InjectPresenter
    lateinit var presenter: HeroesListPresenter

    private var adapter: HeroesAdapter = HeroesAdapter(this::onHeroClick)

    @ProvidePresenter
    fun providePresenter(): HeroesListPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.plus(HeroesModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.heroes_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heroesList.adapter = adapter
        val mLayoutManager = LinearLayoutManager(requireContext())
        heroesList.layoutManager = mLayoutManager
    }

    override fun showHeroes(heroes: List<Hero>) {
        adapter.setItems(heroes)
    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun hideProgress() {
        progressBar.hide()
    }

    private fun onHeroClick(hero: Hero) {
        presenter.onHeroClicked(hero)
    }

    companion object {

        fun newInstance(): HeroesListFragment {

            val args = Bundle()

            val fragment = HeroesListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
