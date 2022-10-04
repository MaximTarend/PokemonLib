package by.hometraining.pokemonlib.repository

import by.hometraining.pokemonlib.model.Pokemon
import by.hometraining.pokemonlib.model.PokemonDetails

interface PokemonRemoteRepository {

    suspend fun getAllPokemons(offset: Int, limit: Int): Result<List<Pokemon>>

    suspend fun getPokemonDetails(name: String): Result<PokemonDetails>
}