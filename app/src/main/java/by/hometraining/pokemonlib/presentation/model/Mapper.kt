package by.hometraining.pokemonlib.presentation.model

import by.hometraining.pokemonlib.domain.model.Pokemon

fun Pokemon.toListItem(): ListItem.Pokemon {
    return ListItem.Pokemon(
        name = name
    )
}