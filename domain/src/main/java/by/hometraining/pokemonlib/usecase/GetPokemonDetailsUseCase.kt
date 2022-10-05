package by.hometraining.pokemonlib.usecase

import by.hometraining.pokemonlib.model.PokemonDetails
import by.hometraining.pokemonlib.repository.PokemonRemoteRepository

class GetPokemonDetailsUseCase(private val pokemonRemoteRepository: PokemonRemoteRepository ) {
    suspend operator fun invoke(name: String): Result<PokemonDetails> {
        return pokemonRemoteRepository.getPokemonDetails(name)
    }
}