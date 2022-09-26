package by.hometrainng.pokemonlib.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.pokemonlib.usecase.GetPokemonDetailsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class DetailsViewModel(
    private val pokemonName: String,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
): ViewModel() {

    val loadDetailsFlow = flow {
        val pokemonDetails = getPokemonDetailsUseCase(pokemonName)
            .fold(
                onSuccess = { it },
                onFailure = { error("FAILURE") }
            )
        emit(pokemonDetails)
    }.shareIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        replay = 1
    )

}