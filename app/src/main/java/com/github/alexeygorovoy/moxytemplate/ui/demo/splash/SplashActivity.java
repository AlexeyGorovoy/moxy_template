package com.github.alexeygorovoy.moxytemplate.ui.demo.splash;

import android.os.Bundle;

import com.github.alexeygorovoy.moxytemplate.R;
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity;


public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
