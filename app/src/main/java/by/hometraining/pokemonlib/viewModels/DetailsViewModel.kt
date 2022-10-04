package by.hometraining.pokemonlib.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometraining.pokemonlib.model.LceState
import by.hometraining.pokemonlib.usecase.GetPokemonDetailsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class DetailsViewModel(
    private val pokemonName: String,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : ViewModel() {

    val loadDetailsFlow = flow {
        val pokemonDetailsState = getPokemonDetailsUseCase(pokemonName)
            .fold(
                onSuccess = { LceState.Content(it) },
                onFailure = { LceState.Error(it) }
            )
        emit(pokemonDetailsState)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = LceState.Loading
    )
}