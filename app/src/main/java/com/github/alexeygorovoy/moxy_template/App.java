package com.github.alexeygorovoy.moxy_template;

import android.app.Application;

import com.github.alexeygorovoy.moxy_template.dagger.app.AppComponent;
import com.github.alexeygorovoy.moxy_template.dagger.app.AppContextModule;
import com.github.alexeygorovoy.moxy_template.dagger.app.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import timber.log.BuildConfig;
import timber.log.Timber;


public class App extends Application {


    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }


    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
