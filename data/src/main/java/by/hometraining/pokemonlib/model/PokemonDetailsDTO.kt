package by.hometraining.pokemonlib.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDTO(
    val id: Int,
    val name: String,
    val types: List<Types>,
    val weight: Int,
    val height: Int,
    @SerializedName("sprites")
    val imageURL: Sprites
) {
    data class Types(
        @SerializedName("type")
        val type: Type
    ) {
        data class Type(
            var name: String
        )
    }

    data class Sprites(
        @SerializedName("front_default")
        val frontDefaultAvatarURL: String
    )
}
