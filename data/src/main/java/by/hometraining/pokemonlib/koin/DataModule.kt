package by.hometraining.pokemonlib.koin

import org.koin.dsl.module

val dataModule = module {
    includes(
        networkModule,
        databaseModule,
        repositoryModule,
        useCaseModule
    )
}
