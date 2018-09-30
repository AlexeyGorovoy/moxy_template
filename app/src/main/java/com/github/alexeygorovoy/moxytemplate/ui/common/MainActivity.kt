package com.github.alexeygorovoy.moxytemplate.ui.common

import android.os.Bundle

import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.ui.common.moxy.BaseMvpFragment
import com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.view.HeroesListFragment

class MainActivity : BaseActivity() {

    private val currentMvpFragment: BaseMvpFragment?
        get() = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseMvpFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceToFragment(HeroesListFragment.newInstance())
        }
    }

    override fun onBackPressed() {
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        if (backStackEntryCount == 1) {
            finish()
        } else {

            val currentMvpFragment = currentMvpFragment
            if (currentMvpFragment?.onBackPressed() == true) {
                return
            }

            super.onBackPressed()
        }
    }
}
