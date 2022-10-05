package by.hometraining.pokemonlib.usecase

import by.hometraining.pokemonlib.model.PokemonDetails
import by.hometraining.pokemonlib.repository.PokemonRepository

class GetPokemonDetailsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(name: String): PokemonDetails {
        return pokemonRepository.getPokemonDetails(name)
    }
}