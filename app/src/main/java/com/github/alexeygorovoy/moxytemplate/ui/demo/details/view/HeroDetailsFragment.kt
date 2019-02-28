package com.github.alexeygorovoy.moxytemplate.ui.demo.details.view

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.dagger.demo.details.HeroDetailsModule
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpFragment
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.presenter.HeroDetailsPresenter
import kotlinx.android.synthetic.main.hero_details_fragment.*
import javax.inject.Inject

class HeroDetailsFragment : BaseMvpFragment(), HeroDetailsView {

    @Inject
    @InjectPresenter
    lateinit var presenter: HeroDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): HeroDetailsPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        val hero = arguments!!.getSerializable(ARG_HERO) as Hero

        activityComponent.plus(HeroDetailsModule(hero)).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.hero_details_fragment, container, false)
    }

    override fun showHero(hero: Hero) {
        Glide.with(requireContext())
            .load(hero.image)
            .into(heroImage)
        heroIntro.text = if (TextUtils.isEmpty(hero.intro)) "no intro" else hero.intro
        heroText.text = if (TextUtils.isEmpty(hero.text)) "no text" else hero.text
    }

    companion object {

        private const val ARG_HERO = "arg_hero"

        fun newInstance(hero: Hero): HeroDetailsFragment {

            val args = Bundle()
            args.putSerializable(ARG_HERO, hero)

            val fragment = HeroDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
