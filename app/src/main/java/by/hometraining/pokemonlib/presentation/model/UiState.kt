package by.hometraining.pokemonlib.presentation.model

sealed class UiState<out T> {

    object Loading : UiState<Nothing>()

    data class Content<T>(val data: T) : UiState<T>()

    data class Error(val throwable: Throwable) : UiState<Nothing>()
}