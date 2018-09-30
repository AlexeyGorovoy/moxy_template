package com.github.alexeygorovoy.moxytemplate.ui.common.moxy

import android.os.Bundle
import android.view.View

import com.arellomobile.mvp.MvpAppCompatFragment
import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity

import es.dmoral.toasty.Toasty
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

    override fun showInfoToast(message: CharSequence) {
        Toasty.info(requireActivity(), message.toString()).show()
    }

    override fun showErrorToast(message: CharSequence) {
        Toasty.error(requireActivity(), message.toString()).show()
    }

    override fun showSuccessToast(message: CharSequence) {
        Toasty.success(requireActivity(), message.toString()).show()
    }

    /**
     * @return true if handled in this method
     */
    fun onBackPressed(): Boolean {
        return false
    }
}
