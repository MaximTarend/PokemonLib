package by.hometraining.pokemonlib.mapper

import by.hometraining.pokemonlib.model.Pokemon
import by.hometraining.pokemonlib.model.PokemonDetails
import by.hometraining.pokemonlib.model.PokemonDetailsDTO
import by.hometraining.pokemonlib.model.PokemonEntity

internal fun PokemonDetailsDTO.toDomainDetailsModel(): PokemonDetails {
    return PokemonDetails(
        id = id,
        name = name,
        types = types.map { it.type.name },
        weight = weight,
        height = height,
        imageURL = imageURL.frontDefaultAvatarURL
    )
}

internal fun PokemonEntity.toDomainDetailsModel(): PokemonDetails {
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

internal fun PokemonEntity.toDomainListModel(): Pokemon {
    return Pokemon(
        name = name
    )
}