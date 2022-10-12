package by.hometraining.pokemonlib.data.database

import androidx.room.Database

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.hometraining.pokemonlib.data.database.converter.TypeConverter
import by.hometraining.pokemonlib.data.model.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(TypeConverter::class)
internal abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}