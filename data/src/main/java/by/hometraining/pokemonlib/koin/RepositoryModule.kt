package by.hometraining.pokemonlib.koin

import by.hometraining.pokemonlib.repository.PokemonRemoteRepository
import by.hometraining.pokemonlib.repository.PokemonRepository
import by.hometraining.pokemonlib.repository.PokemonRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import by.hometraining.pokemonlib.repository.PokemonRemoteRepositoryImpl
import by.hometraining.pokemonlib.repository.PokemonLocalRepository
import by.hometraining.pokemonlib.repository.PokemonLocalRepositoryImpl
import org.koin.core.module.dsl.bind

internal val repositoryModule = module {
    singleOf(::PokemonRemoteRepositoryImpl) {
        bind<PokemonRemoteRepository>()
    }
    singleOf(::PokemonLocalRepositoryImpl) {
        bind<PokemonLocalRepository>()
    }
    singleOf(::PokemonRepositoryImpl) {
        bind<PokemonRepository>()
    }
}