package by.hometrainng.pokemonlib.koin

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

import by.hometrainng.pokemonlib.usecase.GetPokemonsUseCase


internal val useCaseModule = module {
    factoryOf(::GetPokemonsUseCase)
}