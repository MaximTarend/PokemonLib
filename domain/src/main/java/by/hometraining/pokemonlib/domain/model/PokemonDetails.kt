package by.hometraining.pokemonlib.domain.model

data class PokemonDetails(
    val id: Int,
    val name: String,
    val types: List<String>,
    val weight: Int,
    val height: Int,
    val imageURL: String
)