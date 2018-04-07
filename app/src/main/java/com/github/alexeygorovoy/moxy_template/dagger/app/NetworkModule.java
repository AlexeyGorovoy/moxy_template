package com.github.alexeygorovoy.moxy_template.dagger.app;

import com.github.alexeygorovoy.moxy_template.api.HeroApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {

    private static final String BASE_URL = "http://coemygroup.fr/";

    @AppScope
    @Provides
    HeroApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter) {
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return retrofit.create(HeroApi.class);
    }

    @AppScope
    @Provides
    OkHttpClient provideHttpClient(HttpLoggingInterceptor logger) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(logger);
        return builder.build();
    }

    @AppScope
    @Provides
    HttpLoggingInterceptor provideInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    @AppScope
    @Provides
    RxJavaCallAdapterFactory provideRxAdapter() {
        return RxJavaCallAdapterFactory.create();
    }


    @Provides
    GsonConverterFactory provideGsonClient() {
        return GsonConverterFactory.create();
    }

}

