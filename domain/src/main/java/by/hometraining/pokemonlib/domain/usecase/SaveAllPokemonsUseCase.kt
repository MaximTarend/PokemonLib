package by.hometraining.pokemonlib.domain.usecase

import by.hometraining.pokemonlib.domain.model.Pokemon
import by.hometraining.pokemonlib.domain.repository.PokemonRepository

class SaveAllPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(list: List<Pokemon>) : Boolean {
        return pokemonRepository.saveAllPokemons(list)
    }
}