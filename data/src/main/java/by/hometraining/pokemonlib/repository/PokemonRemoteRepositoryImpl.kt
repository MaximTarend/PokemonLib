package by.hometraining.pokemonlib.repository

import by.hometraining.pokemonlib.api.PokemonApi
import by.hometraining.pokemonlib.mapper.toDomainModel
import by.hometraining.pokemonlib.model.Pokemon
import by.hometraining.pokemonlib.model.PokemonDetails

class PokemonRemoteRepositoryImpl(
    private val pokemonApi: PokemonApi
) : PokemonRemoteRepository {
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