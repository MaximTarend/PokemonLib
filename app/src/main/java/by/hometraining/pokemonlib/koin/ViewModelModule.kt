package by.hometraining.pokemonlib.koin

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import by.hometraining.pokemonlib.viewModels.ListViewModel
import by.hometraining.pokemonlib.viewModels.DetailsViewModel

val viewModelModule = module {
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailsViewModel)
}