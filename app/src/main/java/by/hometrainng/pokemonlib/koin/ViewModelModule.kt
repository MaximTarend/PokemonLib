package by.hometrainng.pokemonlib.koin

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import by.hometrainng.pokemonlib.viewModels.ListViewModel

val viewModelModule = module {
    viewModelOf(::ListViewModel)
}