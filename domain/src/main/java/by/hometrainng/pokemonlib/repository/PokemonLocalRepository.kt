package by.hometrainng.pokemonlib.repository

import by.hometrainng.pokemonlib.model.PokemonDetails

interface PokemonLocalRepository {

    suspend fun getPokemonsFromBD() : List<PokemonDetails>

    suspend fun insertPokemonsToDB(pokemons: List<PokemonDetails>)
}