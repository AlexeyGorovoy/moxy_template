package com.github.alexeygorovoy.moxytemplate.ui.common.moxy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.github.alexeygorovoy.moxytemplate.dagger.activity.ActivityComponent;
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity;

import es.dmoral.toasty.Toasty;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BaseMvpFragment extends MvpAppCompatFragment implements BaseMvpView {

    @NonNull
    private CompositeSubscription subscriptions = new CompositeSubscription();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        subscriptions = new CompositeSubscription();
    }

    @Override
    public void onDestroyView() {
        subscriptions.unsubscribe();
        super.onDestroyView();
    }

    protected void unsubscribeOnDestroyView(Subscription subscription) {
        subscriptions.add(subscription);
    }

    @Override
    public void showInfoToast(@NonNull CharSequence message) {
        Toasty.info(requireActivity(), message.toString()).show();
    }

    @Override
    public void showErrorToast(@NonNull CharSequence message) {
        Toasty.error(requireActivity(), message.toString()).show();
    }

    @Override
    public void showSuccessToast(@NonNull CharSequence message) {
        Toasty.success(requireActivity(), message.toString()).show();

    }

    /**
     * @return true if handled in this method
     */
    public boolean onBackPressed() {
        return false;
    }

    protected final ActivityComponent getActivityComponent() {
        return getBaseActivity().getActivityComponent();
    }

    protected final BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }
}
