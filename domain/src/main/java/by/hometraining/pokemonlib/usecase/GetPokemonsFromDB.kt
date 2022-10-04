package by.hometraining.pokemonlib.usecase

import by.hometraining.pokemonlib.model.PokemonDetails
import by.hometraining.pokemonlib.repository.PokemonLocalRepository

class GetPokemonsFromDB(
    private val pokemonLocalRepository: PokemonLocalRepository
) {
    suspend operator fun invoke(): List<PokemonDetails> {
        return pokemonLocalRepository.getPokemonsFromBD()
    }
}