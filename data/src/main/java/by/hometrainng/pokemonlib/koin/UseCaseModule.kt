package by.hometrainng.pokemonlib.koin

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

import by.hometrainng.pokemonlib.usecase.GetPokemonsUseCase
import by.hometrainng.pokemonlib.usecase.GetPokemonDetailsUseCase
import by.hometrainng.pokemonlib.usecase.GetPokemonsFromDB
import by.hometrainng.pokemonlib.usecase.InsertPokemonsToBD


internal val useCaseModule = module {
    factoryOf(::GetPokemonsUseCase)
    factoryOf(::GetPokemonDetailsUseCase)
    factoryOf(::GetPokemonsFromDB)
    factoryOf(::InsertPokemonsToBD)
}