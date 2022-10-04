package by.hometraining.pokemonlib.repository

import by.hometraining.pokemonlib.model.PokemonDetails

interface PokemonLocalRepository {

    suspend fun getPokemonsFromBD(): List<PokemonDetails>

    suspend fun insertPokemonsToDB(pokemons: List<PokemonDetails>)
}