package by.hometraining.pokemonlib.usecase

import by.hometraining.pokemonlib.model.Pokemon
import by.hometraining.pokemonlib.repository.PokemonRepository

class GetAllPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(offset: Int, limit: Int): List<Pokemon> {
        return pokemonRepository.getAllPokemons(offset, limit)
    }
}