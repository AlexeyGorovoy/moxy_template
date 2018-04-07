package com.github.alexeygorovoy.moxy_template.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.alexeygorovoy.moxy_template.R;
import com.github.alexeygorovoy.moxy_template.ui.common.moxy.BaseMvpFragment;
import com.github.alexeygorovoy.moxy_template.ui.demo.heroes.view.HeroesListFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) replaceToFragment(HeroesListFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount == 1) {
            finish();
        } else {

            BaseMvpFragment currentMvpFragment = getCurrentMvpFragment();
            if (currentMvpFragment != null && currentMvpFragment.onBackPressed()) {
                return;
            }

            super.onBackPressed();
        }
    }

    private BaseMvpFragment getCurrentMvpFragment() {
        return (BaseMvpFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
    }
}
