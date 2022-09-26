package by.hometrainng.pokemonlib.koin

import by.hometrainng.pokemonlib.repository.PokemonRemoteRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import by.hometrainng.pokemonlib.repository.PokemonRemoteRepositoryImpl
import by.hometrainng.pokemonlib.repository.PokemonLocalRepository
import by.hometrainng.pokemonlib.repository.PokemonLocalRepositoryImpl
import org.koin.core.module.dsl.bind

internal val repositoryModule = module {
    singleOf(::PokemonRemoteRepositoryImpl) {
        bind<PokemonRemoteRepository>()
    }

    singleOf(::PokemonLocalRepositoryImpl) {
        bind<PokemonLocalRepository>()
    }
}