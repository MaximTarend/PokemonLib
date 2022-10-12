package by.hometraining.pokemonlib.presentation

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import by.hometraining.pokemonlib.data.di.dataModule
import by.hometraining.pokemonlib.presentation.di.useCaseModule
import by.hometraining.pokemonlib.presentation.di.viewModelModule


class PokemonLib : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokemonLib)
            modules(
                dataModule,
                viewModelModule,
                useCaseModule
            )
        }
    }
}