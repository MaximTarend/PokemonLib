package by.hometraining.pokemonlib.domain.repository

import by.hometraining.pokemonlib.domain.model.Pokemon
import by.hometraining.pokemonlib.domain.model.PokemonDetails

interface PokemonRepository {

    suspend fun getAllPokemons(offset: Int, limit: Int) : List<Pokemon>

    suspend fun getPokemonDetails(name: String) : PokemonDetails
}