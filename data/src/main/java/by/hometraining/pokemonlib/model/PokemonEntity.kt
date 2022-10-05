package by.hometraining.pokemonlib.model

import androidx.room.*
import by.hometraining.pokemonlib.database.converter.TypeConverter

@Entity
internal data class PokemonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @TypeConverters(TypeConverter::class)
    val types: List<String>,
    val weight: Int,
    val height: Int,
    @ColumnInfo(name = "image_url")
    val imageURL: String
)