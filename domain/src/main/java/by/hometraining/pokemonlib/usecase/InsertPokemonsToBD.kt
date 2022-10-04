package by.hometraining.pokemonlib.usecase

import by.hometraining.pokemonlib.model.PokemonDetails
import by.hometraining.pokemonlib.repository.PokemonLocalRepository

class InsertPokemonsToBD(
    private val pokemonLocalRepository: PokemonLocalRepository
) {
    suspend operator fun invoke(pokemonList: List<PokemonDetails>) {
        pokemonLocalRepository.insertPokemonsToDB(pokemonList)
    }
}