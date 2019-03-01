package com.github.alexeygorovoy.moxytemplate.dagger.activity

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: FragmentActivity) {

    @Provides
    @ActivityScope
    fun provideActivity() = activity
}
