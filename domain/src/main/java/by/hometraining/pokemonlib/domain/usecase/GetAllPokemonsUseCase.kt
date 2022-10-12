package by.hometraining.pokemonlib.domain.usecase

import by.hometraining.pokemonlib.domain.model.Pokemon
import by.hometraining.pokemonlib.domain.repository.PokemonRepository

class GetAllPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(offset: Int, limit: Int): List<Pokemon> {
        return pokemonRepository.getAllPokemons(offset, limit)
    }
}