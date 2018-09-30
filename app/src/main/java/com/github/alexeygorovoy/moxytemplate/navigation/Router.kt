package com.github.alexeygorovoy.moxytemplate.navigation

import android.app.Activity
import android.content.Intent

import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity
import com.github.alexeygorovoy.moxytemplate.ui.common.MainActivity
import com.github.alexeygorovoy.moxytemplate.ui.demo.details.view.HeroDetailsFragment

class Router {

    fun startMainActivity(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }

    fun openHeroDetails(activity: BaseActivity, hero: Hero) {
        activity.replaceToFragment(HeroDetailsFragment.newInstance(hero))
    }
}
