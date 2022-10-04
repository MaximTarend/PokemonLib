package by.hometraining.pokemonlib.koin

import androidx.room.Room
import by.hometraining.pokemonlib.database.PokemonDatabase
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