package com.github.alexeygorovoy.moxytemplate.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Navigator(
    private val activity: AppCompatActivity,
    private val containerId: Int
) : SupportAppNavigator(activity, containerId) {

    override fun createFragment(screen: SupportAppScreen?): Fragment {
        return super.createFragment(screen)
    }
}