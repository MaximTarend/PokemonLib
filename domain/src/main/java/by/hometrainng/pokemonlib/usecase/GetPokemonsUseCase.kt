package by.hometrainng.pokemonlib.usecase

import by.hometrainng.pokemonlib.model.Pokemon
import by.hometrainng.pokemonlib.repository.PokemonRemoteRepository

class GetPokemonsUseCase(
    private val pokemonRemoteRepository: PokemonRemoteRepository
) {
    suspend operator fun invoke(offset: Int, limit: Int): Result<List<Pokemon>> {
        return pokemonRemoteRepository.getAllPokemons(offset, limit)
    }
}