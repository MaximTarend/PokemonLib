package by.hometrainng.pokemonlib.usecase

import by.hometrainng.pokemonlib.model.PokemonDetails
import by.hometrainng.pokemonlib.repository.PokemonLocalRepository

class InsertPokemonsToBD(
    private val pokemonLocalRepository: PokemonLocalRepository
) {

    suspend operator fun invoke(pokemonList: List<PokemonDetails>) {
        pokemonLocalRepository.insertPokemonsToDB(pokemonList)
    }
}