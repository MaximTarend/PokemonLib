package by.hometraining.pokemonlib.presentation.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import by.hometraining.pokemonlib.domain.usecase.GetAllPokemonsUseCase
import by.hometraining.pokemonlib.domain.usecase.GetPokemonDetailsUseCase
import by.hometraining.pokemonlib.domain.usecase.SaveAllPokemonsUseCase

internal val useCaseModule = module {
    factoryOf(::GetAllPokemonsUseCase)
    factoryOf(::GetPokemonDetailsUseCase)
    factoryOf(::SaveAllPokemonsUseCase)
}