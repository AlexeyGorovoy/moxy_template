package com.github.alexeygorovoy.moxytemplate.ui.common.moxy

import android.os.Bundle
import android.view.View

import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity

import rx.Subscription
import rx.subscriptions.CompositeSubscription

open class BaseMvpFragment : MvpAppCompatFragment(), BaseMvpView {

    private var subscriptions = CompositeSubscription()

    protected val activityComponent: ActivityComponent
        get() = baseActivity.getActivityComponent()

    protected val baseActivity: BaseActivity
        get() = requireActivity() as BaseActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscriptions = CompositeSubscription()
    }

    override fun onDestroyView() {
        subscriptions.unsubscribe()
        super.onDestroyView()
    }

    protected fun Subscription.unsubscribeOnDestroyView() {
        subscriptions.add(this)
    }

    /**
     * @return true if handled in this method
     */
    fun onBackPressed(): Boolean {
        return false
    }
}
