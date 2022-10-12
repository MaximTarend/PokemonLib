package by.hometraining.pokemonlib.domain.usecase

import by.hometraining.pokemonlib.domain.model.PokemonDetails
import by.hometraining.pokemonlib.domain.repository.PokemonRepository

class GetPokemonDetailsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(name: String): PokemonDetails {
        return pokemonRepository.getPokemonDetails(name)
    }
}