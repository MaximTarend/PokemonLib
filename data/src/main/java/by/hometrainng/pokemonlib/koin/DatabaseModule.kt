package by.hometrainng.pokemonlib.koin

import androidx.room.Room
import by.hometrainng.pokemonlib.converter.TypeConverter
import by.hometrainng.pokemonlib.database.PokemonDatabase
import org.koin.dsl.module

internal val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            PokemonDatabase::class.java,
            "pokemon_database.db"
        )
//            .addTypeConverter(TypeConverter)
            .build()
    }

    single { get<PokemonDatabase>().pokemonDao() }
}