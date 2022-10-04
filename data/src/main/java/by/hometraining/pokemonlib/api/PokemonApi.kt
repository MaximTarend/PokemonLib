package by.hometraining.pokemonlib.api

import by.hometraining.pokemonlib.model.PokemonDTO
import by.hometraining.pokemonlib.model.PokemonDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonDTO

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): PokemonDetailsDTO
}