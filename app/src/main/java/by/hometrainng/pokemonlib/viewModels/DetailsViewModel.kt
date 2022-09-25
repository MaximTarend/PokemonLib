package by.hometrainng.pokemonlib.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.pokemonlib.usecase.GetPokemonDetailsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class DetailsViewModel(
    private val name: String,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
): ViewModel() {

    val loadDetailsFlow = flow {
        val pokemonDetails = getPokemonDetailsUseCase(name)
            .fold(
            onSuccess = { it },
            onFailure = { error("yo max it's failure") }
        )
        emit(pokemonDetails)
    }.shareIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        replay = 1
    )

}