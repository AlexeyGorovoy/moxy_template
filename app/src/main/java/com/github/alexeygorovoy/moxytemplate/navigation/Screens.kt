package com.github.alexeygorovoy.moxytemplate.navigation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.ui.common.MainActivity
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.view.HeroDetailsFragment
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.HeroesListFragment
import com.github.alexeygorovoy.moxytemplate.ui.demo.splash.view.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class MainActivityScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    class HeroDetailsScreen(private val hero: Hero) : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return HeroDetailsFragment.newInstance(hero)
        }
    }

    class HeroesListScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return HeroesListFragment()
        }
    }

    class SplashScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SplashFragment()
        }
    }

}