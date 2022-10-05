package by.hometraining.pokemonlib.database

import androidx.room.Database

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.hometraining.pokemonlib.database.converter.TypeConverter
import by.hometraining.pokemonlib.model.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(TypeConverter::class)
internal abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}