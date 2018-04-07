package com.github.alexeygorovoy.moxy_template.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.github.alexeygorovoy.moxy_template.App;
import com.github.alexeygorovoy.moxy_template.R;
import com.github.alexeygorovoy.moxy_template.dagger.activity.ActivityComponent;
import com.github.alexeygorovoy.moxy_template.dagger.activity.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String BACK_STACK_TAG = "back_stack_tag";

    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ((App) getApplication()).getAppComponent().plus(new ActivityModule());
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
    }

    public void replaceToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(BACK_STACK_TAG)
                .commit();
    }
}
