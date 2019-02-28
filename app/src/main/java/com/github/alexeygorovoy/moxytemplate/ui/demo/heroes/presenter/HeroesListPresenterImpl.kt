package com.github.alexeygorovoy.moxytemplate.ui.demo.heroes.presenter

import com.arellomobile.mvp.InjectViewState
import com.github.alexeygorovoy.moxytemplate.api.HeroApi
import com.github.alexeygorovoy.moxytemplate.api.models.Hero
import com.github.alexeygorovoy.moxytemplate.navigation.Router
import com.github.alexeygorovoy.moxytemplate.rx.RxSchedulers
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class HeroesListPresenterImpl @Inject internal constructor(
    private val heroApi: HeroApi,
    private val rxSchedulers: RxSchedulers,
    private val router: Router
) : HeroesListPresenter() {

    private val heroes = ArrayList<Hero>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadHeroesList()
    }

    private fun loadHeroesList() {
        heroApi.getHeroes()
            .delay(500, TimeUnit.MILLISECONDS)
            .compose(rxSchedulers.ioToMain())
            .progress()
            .subscribe(
                { result ->
                    heroes.clear()
                    heroes.addAll(result.elements)
                    viewState.showHeroes(heroes)
                },
                { throwable -> Timber.e(throwable, "Error loading heroes list!") }
            ).unsubscribeOnDestroy()
    }

    override fun onHeroClicked(hero: Hero) {
        router.openHeroDetailsScreen(hero)
    }
}
