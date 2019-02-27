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
import kotlinx.android.synthetic.main.fragment_heroes_list.*
import javax.inject.Inject
import io.card.payment.CardIOActivity
import android.content.Intent



class HeroesListFragment : BaseMvpFragment(), HeroesListView {

    @Inject
    lateinit var router: Router

    @Inject
    @InjectPresenter
    lateinit var presenter: HeroesListPresenter

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

        adapter.onHeroClickedObservable()
            .subscribe { hero -> router.openHeroDetails(baseActivity, hero) }
            .unsubscribeOnDestroyView()

        heroesList.adapter = adapter
        val mLayoutManager = LinearLayoutManager(requireContext())
        heroesList.layoutManager = mLayoutManager

        cardButton.setOnClickListener { onScanPress() }
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

    fun onScanPress() {
        val scanIntent = Intent(this.context, CardIOActivity::class.java)

        // customize these values to suit your needs.
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_GUIDE_COLOR, resources.getColor(R.color.bla)) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CARDHOLDER_NAME, true) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_HIDE_CARDIO_LOGO, true) // default: false

        // MY_SCAN_REQUEST_CODE is arbitrary and is only used within this activity.
        startActivityForResult(scanIntent, 0)
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
