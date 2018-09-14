package com.github.alexeygorovoy.moxy_template.ui.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

import com.github.alexeygorovoy.moxy_template.App
import com.github.alexeygorovoy.moxy_template.R
import com.github.alexeygorovoy.moxy_template.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.moxy_template.dagger.activity.ActivityModule

abstract class BaseActivity : AppCompatActivity() {

    private var activityComponent: ActivityComponent? = null

    fun getActivityComponent(): ActivityComponent {
        return activityComponent ?: createComponent()
            .also { activityComponent = it }
    }

    private fun createComponent() = (application as App).appComponent.plus(ActivityModule())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)
    }

    fun replaceToFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(BACK_STACK_TAG)
            .commit()
    }

    companion object {

        private const val BACK_STACK_TAG = "back_stack_tag"
    }
}
