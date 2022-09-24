package by.hometrainng.pokemonlib.database

import androidx.room.Database
import by.hometrainng.pokemonlib.model.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
internal abstract class PokemonDatabase {

    abstract fun pokemonDao(): PokemonDao
}