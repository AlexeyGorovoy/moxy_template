package com.github.alexeygorovoy.moxytemplate.api

import com.github.alexeygorovoy.moxytemplate.api.models.Heroes

import retrofit2.http.GET
import rx.Observable

interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    fun getHeroes(): Observable<Heroes>
}
