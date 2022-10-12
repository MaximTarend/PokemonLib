package by.hometraining.pokemonlib.presentation.model

sealed class ListItem {

    object Loading : ListItem()

    data class Pokemon(
        val name: String
    ) : ListItem()
}