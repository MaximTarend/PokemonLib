package by.hometraining.pokemonlib.presentation.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometraining.pokemonlib.domain.usecase.GetAllPokemonsUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class ListViewModel(
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
        .onEach { offset += OFFSET }
        .runningReduce { accumulator, value -> accumulator + value }
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            replay = 1
        )

/*    val loadDataFlow = loadFlow
        .map {
            getPokemonsUseCase(offset, LIMIT)
                .fold(
                    onSuccess = { it },
                    onFailure = { emptyList() }
                )
        }
        .onEach {
            val listToDB = mutableListOf<PokemonDetails>()
            it.onEach { pokemon ->
                getPokemonDetailsUseCase(pokemon.name)
                    .getOrNull()?.let { pokemonDetails -> listToDB.add(pokemonDetails) }
            }
            insertPokemonsToBD(listToDB)
            offset += OFFSET
        }
        .runningReduce { accumulator, value -> accumulator + value }
        .onStart {
            emit(getPokemonsFromDB().map { pokemonDetails ->
                pokemonDetails.toPokemonModel()
            })
        }
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            replay = 1
        )*/

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