package by.hometraining.pokemonlib.koin

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

import by.hometraining.pokemonlib.usecase.GetPokemonsUseCase
import by.hometraining.pokemonlib.usecase.GetAllPokemonsUseCase
import by.hometraining.pokemonlib.usecase.GetPokemonDetailsUseCase
import by.hometraining.pokemonlib.usecase.GetPokemonsFromDB
import by.hometraining.pokemonlib.usecase.InsertPokemonsToDB


internal val useCaseModule = module {
    factoryOf(::GetAllPokemonsUseCase)
    factoryOf(::GetPokemonDetailsUseCase)

    factoryOf(::GetPokemonsUseCase)
    factoryOf(::GetPokemonsFromDB)
    factoryOf(::InsertPokemonsToDB)
}