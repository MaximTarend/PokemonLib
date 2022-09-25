package by.hometrainng.pokemonlib.repository

import by.hometrainng.pokemonlib.model.Pokemon
import by.hometrainng.pokemonlib.model.PokemonDetails

interface PokemonRemoteRepository {

    suspend fun getAllPokemons(offset: Int, limit: Int): Result<List<Pokemon>>

    suspend fun getPokemonDetails(name: String): Result<PokemonDetails>
}