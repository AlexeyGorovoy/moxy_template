package com.github.alexeygorovoy.moxytemplate.ui.demo.splash

import android.os.Bundle

import com.github.alexeygorovoy.moxytemplate.R
import com.github.alexeygorovoy.moxytemplate.ui.common.BaseActivity

class SplashActivity : BaseActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
    }
}
