package by.hometrainng.pokemonlib.koin

import by.hometrainng.pokemonlib.repository.PokemonRemoteRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import by.hometrainng.pokemonlib.repository.PokemonRemoteRepositoryImpl
import org.koin.core.module.dsl.bind

internal val repositoryModule = module {
    singleOf(::PokemonRemoteRepositoryImpl) {
        bind<PokemonRemoteRepository>()
    }
}