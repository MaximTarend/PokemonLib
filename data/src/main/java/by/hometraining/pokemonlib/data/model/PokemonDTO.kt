package by.hometraining.pokemonlib.data.model

import by.hometraining.pokemonlib.domain.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonDTO(
    val count: Int,
    @SerializedName("results")
    val list: List<Pokemon>
)