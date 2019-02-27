package com.github.alexeygorovoy.moxytemplate.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.github.alexeygorovoy.moxytemplate.App
import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityModule

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
