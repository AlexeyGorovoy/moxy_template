package com.github.alexeygorovoy.moxytemplate.dagger.app

import com.github.alexeygorovoy.moxytemplate.navigation.Router
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

@Module
class NavigationModule {

    @Provides
    @AppScope
    fun provideCicerone(router: Router) = Cicerone.create(router)

    @Provides
    @AppScope
    fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @AppScope
    fun provideRouter() = Router()
}