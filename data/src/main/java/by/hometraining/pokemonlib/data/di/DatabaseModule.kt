package by.hometraining.pokemonlib.data.di

import androidx.room.Room
import by.hometraining.pokemonlib.data.database.PokemonDatabase
import org.koin.dsl.module

internal val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            PokemonDatabase::class.java,
            "pokemon_database.db"
        ).build()
    }
    single { get<PokemonDatabase>().pokemonDao() }
}