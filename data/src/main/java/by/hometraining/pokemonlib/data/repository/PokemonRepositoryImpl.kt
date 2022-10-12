package by.hometraining.pokemonlib.data.repository

import by.hometraining.pokemonlib.data.api.PokemonApi
import by.hometraining.pokemonlib.data.database.PokemonDao
import by.hometraining.pokemonlib.data.model.PokemonEntity
import by.hometraining.pokemonlib.data.model.mapper.toDomainDetailsModel
import by.hometraining.pokemonlib.data.model.mapper.toDomainListModel
import by.hometraining.pokemonlib.data.model.mapper.toPokemonEntity
import by.hometraining.pokemonlib.domain.model.Pokemon
import by.hometraining.pokemonlib.domain.model.PokemonDetails
import by.hometraining.pokemonlib.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val pokemonApi: PokemonApi,
) : PokemonRepository {

    override suspend fun getAllPokemons(offset: Int, limit: Int): List<Pokemon> {
        return getPokemonsFromRemoteStorage(offset, limit).fold(
            onFailure = { getPokemonsFromLocalStorage() },
            onSuccess = { it }
        )
    }

    override suspend fun getPokemonDetails(name: String): PokemonDetails {
        return getPokemonDetailsFromRemoteStorage(name).fold(
            onFailure = { getPokemonDetailsFromLocalStorage(name) },
            onSuccess = { it }
        )
    }

    override suspend fun saveAllPokemons(list: List<Pokemon>): Boolean {
        val pokemonEntityList = mutableListOf<PokemonEntity>()
        list.map { pokemon ->
            getPokemonDetailsFromRemoteStorage(pokemon.name)
                .onSuccess {
                    pokemonEntityList.add(it.toPokemonEntity())
                }
                .onFailure {
                    return false
                }
        }
        pokemonDao.insertPokemons(pokemonEntityList.toList())
        return true
    }

    private suspend fun getPokemonsFromRemoteStorage(
        offset: Int,
        limit: Int
    ): Result<List<Pokemon>> {
        return runCatching { pokemonApi.getPokemonList(offset, limit).list }
    }

    private suspend fun getPokemonDetailsFromRemoteStorage(name: String): Result<PokemonDetails> {
        return runCatching { pokemonApi.getPokemonDetails(name).toDomainDetailsModel() }
    }

    private suspend fun getPokemonsFromLocalStorage(): List<Pokemon> {
        return pokemonDao.getPokemons().map { it.toDomainListModel() }
    }

    private suspend fun getPokemonDetailsFromLocalStorage(name: String): PokemonDetails {
        return pokemonDao.getPokemonByName(name).toDomainDetailsModel()
    }
}