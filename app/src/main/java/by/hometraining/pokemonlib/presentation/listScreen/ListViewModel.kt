package by.hometraining.pokemonlib.presentation.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometraining.pokemonlib.domain.model.Pokemon
import by.hometraining.pokemonlib.domain.usecase.GetAllPokemonsUseCase
import by.hometraining.pokemonlib.domain.usecase.SaveAllPokemonsUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class ListViewModel(
    private val saveAllPokemonsUseCase: SaveAllPokemonsUseCase,
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase
) : ViewModel() {

    private var offset = 0

    private val loadFlow = MutableSharedFlow<Unit>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val loadDataFlow = loadFlow
        .map { getAllPokemonsUseCase(offset, LIMIT) }
        .onEach {
            saveAllPokemonsUseCase(it)
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