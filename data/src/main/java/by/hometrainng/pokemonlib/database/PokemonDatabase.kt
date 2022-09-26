package by.hometrainng.pokemonlib.database

import androidx.room.Database

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.hometrainng.pokemonlib.converter.TypeConverter
import by.hometrainng.pokemonlib.model.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(TypeConverter::class)
internal abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}