package by.hometrainng.pokemonlib.koin

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import by.hometrainng.pokemonlib.viewModels.ListViewModel
import by.hometrainng.pokemonlib.viewModels.DetailsViewModel

val viewModelModule = module {
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailsViewModel)
}