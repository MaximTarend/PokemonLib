package by.hometrainng.pokemonlib.model

import com.google.gson.annotations.SerializedName

data class ApiListObject(
    val count: Int,
    @SerializedName("results")
    val list: List<Pokemon>
)