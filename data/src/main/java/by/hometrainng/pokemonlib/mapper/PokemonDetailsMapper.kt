package by.hometrainng.pokemonlib.mapper

import by.hometrainng.pokemonlib.model.PokemonDetails
import by.hometrainng.pokemonlib.model.PokemonDetailsDTO
import by.hometrainng.pokemonlib.model.PokemonEntity

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

internal fun PokemonEntity.toDomainModel(): PokemonDetails {
    return PokemonDetails(
        id = id,
        name = name,
        types = types,
        weight = weight,
        height = height,
        imageURL = imageURL
    )
}

internal fun PokemonDetails.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        id = id,
        name = name,
        types = types,
        weight = weight,
        height = height,
        imageURL = imageURL
    )
}