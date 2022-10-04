package by.hometraining.pokemonlib.koin

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

import by.hometraining.pokemonlib.usecase.GetPokemonsUseCase
import by.hometraining.pokemonlib.usecase.GetPokemonDetailsUseCase
import by.hometraining.pokemonlib.usecase.GetPokemonsFromDB
import by.hometraining.pokemonlib.usecase.InsertPokemonsToBD


internal val useCaseModule = module {
    factoryOf(::GetPokemonsUseCase)
    factoryOf(::GetPokemonDetailsUseCase)
    factoryOf(::GetPokemonsFromDB)
    factoryOf(::InsertPokemonsToBD)
}