package by.hometrainng.pokemonlib.koin

import by.hometrainng.pokemonlib.api.PokemonApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(" https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create<PokemonApi>()
    }
}