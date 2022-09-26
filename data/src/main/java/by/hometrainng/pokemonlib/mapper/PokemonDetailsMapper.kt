package by.hometrainng.pokemonlib.mapper

import by.hometrainng.pokemonlib.model.PokemonDetails
import by.hometrainng.pokemonlib.model.PokemonDetailsDTO

internal fun PokemonDetailsDTO.toDomainModel(): PokemonDetails {
    return PokemonDetails(
        id = id,
        name = name,
        types = types.map { it.type.name },
        weight = weight,
        height = height,
        imageURL = imageURL.frontDefaultAvatarURL
    )
}