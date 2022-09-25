package by.hometrainng.pokemonlib.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.pokemonlib.api.PokemonApi
import by.hometrainng.pokemonlib.usecase.GetPokemonsUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class PokemonListViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase
): ViewModel() {

    private var offset = 0

    private val loadFlow = MutableSharedFlow<Unit>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val loadDataFlow = loadFlow
        .map {
            getPokemonsUseCase(offset, LIMIT)
                .fold(
                    onSuccess = { it },
                    onFailure = { emptyList() }
                )
        }
        .onEach {
            offset += OFFSET
        }
        .runningReduce { accumulator, value -> accumulator + value }
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            replay = 1
        )

    init {
        onLoadMore()
    }

    fun onLoadMore() {
        loadFlow.tryEmit(Unit)
    }

    companion object {
        private const val OFFSET = 30
        private const val LIMIT = 30
    }
}