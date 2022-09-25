package by.hometrainng.pokemonlib

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import by.hometrainng.pokemonlib.koin.dataModule


class PokemonLib: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokemonLib)
            modules(
                dataModule
            )
        }
    }
}