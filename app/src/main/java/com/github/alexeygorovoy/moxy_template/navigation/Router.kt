package com.github.alexeygorovoy.moxy_template.navigation

import android.app.Activity
import android.content.Intent

import com.github.alexeygorovoy.moxy_template.api.models.Hero
import com.github.alexeygorovoy.moxy_template.ui.common.BaseActivity
import com.github.alexeygorovoy.moxy_template.ui.common.MainActivity
import com.github.alexeygorovoy.moxy_template.ui.demo.details.view.HeroDetailsFragment

class Router {

    fun startMainActivity(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }

    fun openHeroDetails(activity: BaseActivity, hero: Hero) {
        activity.replaceToFragment(HeroDetailsFragment.newInstance(hero))
    }
}
