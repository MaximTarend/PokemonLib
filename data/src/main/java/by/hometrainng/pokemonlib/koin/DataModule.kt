package by.hometrainng.pokemonlib.koin

import org.koin.dsl.module

val dataModule = module {
    includes(
        networkModule,
        databaseModule,
        repositoryModule,
        useCaseModule
    )
}
