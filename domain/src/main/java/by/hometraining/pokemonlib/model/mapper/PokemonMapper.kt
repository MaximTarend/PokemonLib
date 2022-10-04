package by.hometraining.pokemonlib

import by.hometraining.pokemonlib.model.Pokemon
import by.hometraining.pokemonlib.model.PokemonDetails

fun PokemonDetails.toPokemonModel(): Pokemon {
    return Pokemon(
        name = name
    )
}