package by.hometrainng.pokemonlib.repository

import by.hometrainng.pokemonlib.api.PokemonApi
import by.hometrainng.pokemonlib.model.Pokemon

class PokemonRemoteRepositoryImpl(
    private val pokemonApi: PokemonApi
): PokemonRemoteRepository {
    override suspend fun getAllPokemons(offset: Int, limit: Int): Result<List<Pokemon>> {
        return kotlin.runCatching {
            pokemonApi.getPokemonList(offset, limit).list
        }
    }
}