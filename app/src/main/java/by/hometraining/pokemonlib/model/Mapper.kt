package by.hometraining.pokemonlib.model

fun Pokemon.toListItem(): ListItem.Pokemon {
    return ListItem.Pokemon(
        name = name
    )
}