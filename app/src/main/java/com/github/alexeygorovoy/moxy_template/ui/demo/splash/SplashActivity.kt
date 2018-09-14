package com.github.alexeygorovoy.moxy_template.ui.demo.splash

import android.os.Bundle

import com.github.alexeygorovoy.moxy_template.R
import com.github.alexeygorovoy.moxy_template.ui.common.BaseActivity

class SplashActivity : BaseActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
    }
}
