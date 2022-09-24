package by.hometrainng.pokemonlib.api

import by.hometrainng.pokemonlib.model.PokemonDTO
import by.hometrainng.pokemonlib.model.PokemonDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): List<PokemonDTO>

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): PokemonDetailsDTO
}