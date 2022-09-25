package by.hometrainng.pokemonlib.usecase

import by.hometrainng.pokemonlib.model.Pokemon
import by.hometrainng.pokemonlib.model.PokemonDetails
import by.hometrainng.pokemonlib.repository.PokemonRemoteRepository

class GetPokemonDetailsUseCase(
    private val pokemonRemoteRepository: PokemonRemoteRepository
) {
    suspend operator fun invoke(name: String): Result<PokemonDetails> {
        return pokemonRemoteRepository.getPokemonDetails(name)
    }
}