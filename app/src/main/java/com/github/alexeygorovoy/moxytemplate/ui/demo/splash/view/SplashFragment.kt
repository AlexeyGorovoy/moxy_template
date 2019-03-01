package com.github.alexeygorovoy.moxytemplate.ui.demo.splash.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.dagger.demo.splash.SplashModule
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpFragment
import com.github.alexeygorovoy.moxytemplate.ui.demo.splash.presenter.SplashPresenter
import javax.inject.Inject

class SplashFragment : BaseMvpFragment(), SplashView {

    @Inject
    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter {
        return splashPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.plus(SplashModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }
}
