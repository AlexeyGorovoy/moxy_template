package com.github.alexeygorovoy.moxytemplate.dagger.app;

import android.content.Context;

import dagger.Module;
import dagger.Provides;


@Module
public class AppContextModule {


    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }

}
