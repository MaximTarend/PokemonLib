package by.hometrainng.pokemonlib.model

import com.google.gson.annotations.SerializedName

data class PokemonDTO(
    val count: Int,
    @SerializedName("results")
    val list: List<Pokemon>
)