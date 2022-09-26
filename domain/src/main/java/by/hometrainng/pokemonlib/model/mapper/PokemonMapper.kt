package by.hometrainng.pokemonlib

import by.hometrainng.pokemonlib.model.Pokemon
import by.hometrainng.pokemonlib.model.PokemonDetails

fun PokemonDetails.toMainModel(): Pokemon {
    return Pokemon(
        name = name
    )
}