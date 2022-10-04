package by.hometraining.pokemonlib.usecase

import by.hometraining.pokemonlib.model.Pokemon
import by.hometraining.pokemonlib.repository.PokemonRemoteRepository

class GetPokemonsUseCase(
    private val pokemonRemoteRepository: PokemonRemoteRepository
) {
    suspend operator fun invoke(offset: Int, limit: Int): Result<List<Pokemon>> {
        return pokemonRemoteRepository.getAllPokemons(offset, limit)
    }
}