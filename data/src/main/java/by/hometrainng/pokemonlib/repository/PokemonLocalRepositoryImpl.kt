package by.hometrainng.pokemonlib.repository

import by.hometrainng.pokemonlib.database.PokemonDao
import by.hometrainng.pokemonlib.mapper.toDomainModel
import by.hometrainng.pokemonlib.mapper.toPokemonEntity
import by.hometrainng.pokemonlib.model.PokemonDetails

internal class PokemonLocalRepositoryImpl(
    private val pokemonDao: PokemonDao
) : PokemonLocalRepository {
    override suspend fun getPokemonsFromBD(): List<PokemonDetails> {
        return pokemonDao.getPokemons().map {
            it.toDomainModel()
        }
    }

    override suspend fun insertPokemonsToDB(pokemons: List<PokemonDetails>) {
        pokemonDao.insertPokemons(
            pokemons.map {
                it.toPokemonEntity()
            }
        )
    }
}