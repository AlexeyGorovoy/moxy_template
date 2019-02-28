package com.github.alexeygorovoy.moxytemplate.ui.common.moxy

import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity

open class BaseMvpFragment : MvpAppCompatFragment(), BaseMvpView {

    protected val activityComponent: ActivityComponent
        get() = baseActivity.getActivityComponent()

    protected val baseActivity: BaseActivity
        get() = requireActivity() as BaseActivity

    /**
     * @return true if handled in this method
     */
    fun onBackPressed(): Boolean {
        return false
    }
}
