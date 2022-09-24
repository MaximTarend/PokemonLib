package by.hometrainng.pokemonlib.database

import androidx.room.Database

import androidx.room.RoomDatabase
import by.hometrainng.pokemonlib.model.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
internal abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}