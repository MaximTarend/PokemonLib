package by.hometrainng.pokemonlib.repository

import by.hometrainng.pokemonlib.api.PokemonApi
import by.hometrainng.pokemonlib.mapper.toDomainModel
import by.hometrainng.pokemonlib.model.Pokemon
import by.hometrainng.pokemonlib.model.PokemonDetails

class PokemonRemoteRepositoryImpl(
    private val pokemonApi: PokemonApi
): PokemonRemoteRepository {
    override suspend fun getAllPokemons(offset: Int, limit: Int): Result<List<Pokemon>> {
        return runCatching {
            pokemonApi.getPokemonList(offset, limit).list
        }
    }

    override suspend fun getPokemonDetails(name: String): Result<PokemonDetails> {
        return runCatching {
            pokemonApi.getPokemonDetails(name).toDomainModel()
        }
    }
}