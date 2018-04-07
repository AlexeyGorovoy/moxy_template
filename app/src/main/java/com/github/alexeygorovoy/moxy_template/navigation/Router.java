package com.github.alexeygorovoy.moxy_template.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.github.alexeygorovoy.moxy_template.api.models.Hero;
import com.github.alexeygorovoy.moxy_template.ui.common.BaseActivity;
import com.github.alexeygorovoy.moxy_template.ui.common.MainActivity;
import com.github.alexeygorovoy.moxy_template.ui.demo.details.view.HeroDetailsFragment;

public class Router {

    public void startMainActivity(@NonNull Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    public void openHeroDetails(@NonNull BaseActivity activity, @NonNull Hero hero) {
        activity.replaceToFragment(HeroDetailsFragment.newInstance(hero));
    }
}
