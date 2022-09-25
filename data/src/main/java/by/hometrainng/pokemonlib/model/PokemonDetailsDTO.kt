package by.hometrainng.pokemonlib.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDTO(
    val id: Int,
    val name: String,
    val types: List<Type>,
    val weight: Int,
    val height: Int,
    @SerializedName("sprites/front_default") // TODO проверить правильность доступа к параметру
    val imageURL: String
)

data class Type(
    val name: String
)