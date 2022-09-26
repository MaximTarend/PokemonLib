package by.hometrainng.pokemonlib.model

fun Pokemon.toListItem(): ListItem.Pokemon {
    return ListItem.Pokemon(
        name = name
    )
}