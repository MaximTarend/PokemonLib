package by.hometrainng.pokemonlib.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class PokemonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: List<String>,
    val weight: Int,
    val height: Int,
    @ColumnInfo(name = "image_url")
    val imageURL: String
        )