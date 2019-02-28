package com.github.alexeygorovoy.moxytemplate.navigation

import ru.terrakok.cicerone.Router
import com.github.alexeygorovoy.moxytemplate.api.models.Hero

class Router: Router() {

    fun openHeroListScreen() {
        newRootScreen(Screens.HeroesListScreen())
    }

    fun openHeroDetailsScreen(hero: Hero) {
        navigateTo(Screens.HeroDetailsScreen(hero))
    }
}
