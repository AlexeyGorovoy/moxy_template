package com.github.alexeygorovoy.moxy_template.ui.demo.heroes.view

import android.os.Bundle
import android.support.v4.widget.ContentLoadingProgressBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.alexeygorovoy.moxy_template.R
import com.github.alexeygorovoy.moxy_template.api.models.Hero
import com.github.alexeygorovoy.moxy_template.dagger.demo.heroes.HeroesModule
import com.github.alexeygorovoy.moxy_template.navigation.Router
import com.github.alexeygorovoy.moxy_template.ui.common.moxy.BaseMvpFragment
import com.github.alexeygorovoy.moxy_template.ui.demo.heroes.presenter.HeroesListPresenter
import com.github.alexeygorovoy.moxy_template.ui.demo.heroes.view.adapter.HeroesAdapter
import javax.inject.Inject

class HeroesListFragment : BaseMvpFragment(), HeroesListView {

    @Inject
    lateinit var router: Router

    @Inject
    @InjectPresenter
    lateinit var presenter: HeroesListPresenter

    @BindView(R.id.heroes_list)
    lateinit var list: RecyclerView

    @BindView(R.id.progress_bar)
    lateinit var progressBar: ContentLoadingProgressBar

    private var adapter: HeroesAdapter = HeroesAdapter()

    @ProvidePresenter
    fun providePresenter(): HeroesListPresenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.plus(HeroesModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_heroes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ButterKnife.bind(this, view)

        val sub = adapter.onHeroClickedObservable()
            .subscribe { hero -> router.openHeroDetails(baseActivity, hero) }
        unsubscribeOnDestroyView(sub)

        list.adapter = adapter
        val mLayoutManager = LinearLayoutManager(requireContext())
        list.layoutManager = mLayoutManager
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

    companion object {

        fun newInstance(): HeroesListFragment {

            val args = Bundle()

            val fragment = HeroesListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
