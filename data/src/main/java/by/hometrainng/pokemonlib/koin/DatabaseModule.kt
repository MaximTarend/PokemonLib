package by.hometrainng.pokemonlib.koin

import androidx.room.Room
import by.hometrainng.pokemonlib.database.PokemonDatabase
import org.koin.dsl.module

internal val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            PokemonDatabase::class.java,
            "pokemon_database.db"
        )
    }

    single { get<PokemonDatabase>().pokemonDao() }
}