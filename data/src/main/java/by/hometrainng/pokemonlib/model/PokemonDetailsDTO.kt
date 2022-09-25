package by.hometrainng.pokemonlib.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDTO(
    val id: Int,
    val name: String,
    val types: List<Type>,
    val weight: Int,
    val height: Int,
    @SerializedName("sprites") // TODO проверить правильность доступа к параметру
    val imageURL: Sprite
) {
    data class Type(
        @SerializedName("name")
        val typeName: String
    )
    data class Sprite(
        @SerializedName("front_default")
        val frontDefaultAvatarURL: String
    )
}

