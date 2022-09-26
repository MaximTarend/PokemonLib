package by.hometrainng.pokemonlib.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.hometrainng.pokemonlib.model.PokemonDetails
import by.hometrainng.pokemonlib.toListModel
import by.hometrainng.pokemonlib.usecase.GetPokemonDetailsUseCase
import by.hometrainng.pokemonlib.usecase.GetPokemonsFromDB
import by.hometrainng.pokemonlib.usecase.GetPokemonsUseCase
import by.hometrainng.pokemonlib.usecase.InsertPokemonsToBD
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class ListViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val insertPokemonsToBD: InsertPokemonsToBD,
    private val getPokemonsFromDB: GetPokemonsFromDB,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
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
            val listToDB = mutableListOf<PokemonDetails>()
            it.onEach { pokemon ->
                getPokemonDetailsUseCase(pokemon.name)
                    .getOrNull()?.let { pokemonDetails -> listToDB.add(pokemonDetails) }
            }
            insertPokemonsToBD(listToDB)
            offset += OFFSET
        }
        .runningReduce { accumulator, value -> accumulator + value }
        .onStart { emit(getPokemonsFromDB().map {
            it.toListModel()
        }) }
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