package by.hometraining.pokemonlib.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import by.hometraining.pokemonlib.presentation.listScreen.ListViewModel
import by.hometraining.pokemonlib.presentation.detailsScreen.DetailsViewModel

val viewModelModule = module {
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailsViewModel)
}