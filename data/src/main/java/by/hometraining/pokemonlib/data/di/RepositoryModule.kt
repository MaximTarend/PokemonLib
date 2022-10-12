package by.hometraining.pokemonlib.data.di

import by.hometraining.pokemonlib.domain.repository.PokemonRepository
import by.hometraining.pokemonlib.data.repository.PokemonRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

internal val repositoryModule = module {
    singleOf(::PokemonRepositoryImpl) {
        bind<PokemonRepository>()
    }
}