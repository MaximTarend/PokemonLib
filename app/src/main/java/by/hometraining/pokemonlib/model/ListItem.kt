package by.hometraining.pokemonlib.model

sealed class ListItem {

    object Loading : ListItem()

    data class Pokemon(
        val name: String
    ) : ListItem()
}