package by.hometraining.pokemonlib.repository

import by.hometraining.pokemonlib.database.PokemonDao
import by.hometraining.pokemonlib.mapper.toDomainDetailsModel
import by.hometraining.pokemonlib.mapper.toPokemonEntity
import by.hometraining.pokemonlib.model.PokemonDetails

internal class PokemonLocalRepositoryImpl(private val pokemonDao: PokemonDao) : PokemonLocalRepository {

    override suspend fun getPokemonsFromDB(): List<PokemonDetails> {
        return pokemonDao.getPokemons().map {
            it.toDomainDetailsModel()
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