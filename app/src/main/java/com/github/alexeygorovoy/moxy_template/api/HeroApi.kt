package com.github.alexeygorovoy.moxy_template.api

import com.github.alexeygorovoy.moxy_template.api.models.Heroes

import retrofit2.http.GET
import rx.Observable

interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    fun getHeroes(): Observable<Heroes>
}
