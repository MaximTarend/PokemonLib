package by.hometraining.pokemonlib.presentation.detailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometraining.pokemonlib.domain.usecase.GetPokemonDetailsUseCase
import by.hometraining.pokemonlib.presentation.model.UiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn

class DetailsViewModel(
    private val pokemonName: String,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : ViewModel() {

    val loadDetailsFlow = flow {
        val pokemonDetailsState = getPokemonDetailsUseCase(pokemonName)
        emit(pokemonDetailsState)
    }.shareIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        replay = 1
    )

/*    val loadDetailsFlow = flow {
        val pokemonDetailsState = getPokemonDetailsUseCase(pokemonName)
        emit(pokemonDetailsState)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = LceState.Loading
    )*/
}