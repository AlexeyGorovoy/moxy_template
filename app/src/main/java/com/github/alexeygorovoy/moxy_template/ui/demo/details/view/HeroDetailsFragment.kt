package com.github.alexeygorovoy.moxy_template.ui.demo.details.view

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.github.alexeygorovoy.moxy_template.R
import com.github.alexeygorovoy.moxy_template.api.models.Hero
import com.github.alexeygorovoy.moxy_template.dagger.demo.details.HeroDetailsModule
import com.github.alexeygorovoy.moxy_template.ui.common.moxy.BaseMvpFragment
import com.github.alexeygorovoy.moxy_template.ui.demo.details.presenter.HeroDetailsPresenter

import javax.inject.Inject

import butterknife.BindView
import butterknife.ButterKnife
import timber.log.Timber

class HeroDetailsFragment : BaseMvpFragment(), HeroDetailsView {

    @Inject
    @InjectPresenter
    lateinit var presenter: HeroDetailsPresenter

    @BindView(R.id.hero_image)
    lateinit var imageHero: ImageView

    @BindView(R.id.hero_intro)
    lateinit var introduction: TextView

    @BindView(R.id.hero_text)
    lateinit var text: TextView

    @ProvidePresenter
    fun providePresenter(): HeroDetailsPresenter {
        val arguments = arguments
        if (arguments != null) {
            val hero = arguments.getSerializable(ARG_HERO) as? Hero
            if (hero != null) {
                presenter.setHero(hero)
            } else {
                Timber.e("No hero provided!")
            }
        }
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.plus(HeroDetailsModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hero_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ButterKnife.bind(this, view)
    }

    override fun showHero(hero: Hero) {
        Glide.with(requireContext())
            .load(hero.image)
            .into(imageHero)
        introduction.text = if (TextUtils.isEmpty(hero.intro)) "no intro" else hero.intro
        text.text = if (TextUtils.isEmpty(hero.text)) "no text" else hero.text
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
