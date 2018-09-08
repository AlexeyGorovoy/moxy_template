package com.github.alexeygorovoy.moxy_template.api.models
import java.io.Serializable

data class Hero(val image: String, val title: String, val intro: String, val year: String, val text: String, val color: String) : Serializable

data class Heroes (var elements: List<Hero>)
