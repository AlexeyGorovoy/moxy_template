package com.github.alexeygorovoy.moxytemplate.api

import com.github.alexeygorovoy.moxytemplate.api.models.Heroes
import io.reactivex.Observable

import retrofit2.http.GET

interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    fun getHeroes(): Observable<Heroes>
}
