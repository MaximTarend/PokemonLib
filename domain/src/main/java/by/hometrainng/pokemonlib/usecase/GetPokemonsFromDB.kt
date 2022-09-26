package by.hometrainng.pokemonlib.usecase

import by.hometrainng.pokemonlib.model.PokemonDetails
import by.hometrainng.pokemonlib.repository.PokemonLocalRepository

class GetPokemonsFromDB(
    private val pokemonLocalRepository: PokemonLocalRepository
) {
    suspend operator fun invoke(): List<PokemonDetails> {
        return pokemonLocalRepository.getPokemonsFromBD()
    }

}