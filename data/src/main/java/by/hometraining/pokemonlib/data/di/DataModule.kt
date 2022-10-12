package by.hometraining.pokemonlib.data.di

import org.koin.dsl.module

val dataModule = module {
    includes(
        networkModule,
        databaseModule,
        repositoryModule,
    )
}
