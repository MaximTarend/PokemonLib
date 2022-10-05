package by.hometraining.pokemonlib.repository

import by.hometraining.pokemonlib.model.Pokemon
import by.hometraining.pokemonlib.model.PokemonDetails

interface PokemonRepository {

    suspend fun getAllPokemons(offset: Int, limit: Int) : List<Pokemon>

    suspend fun getPokemonDetails(name: String) : PokemonDetails
}