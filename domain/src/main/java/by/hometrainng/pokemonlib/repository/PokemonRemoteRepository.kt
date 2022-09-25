package by.hometrainng.pokemonlib.repository

import by.hometrainng.pokemonlib.model.Pokemon

interface PokemonRemoteRepository {

    suspend fun getAllPokemons(offset: Int, limit: Int): Result<List<Pokemon>>
}