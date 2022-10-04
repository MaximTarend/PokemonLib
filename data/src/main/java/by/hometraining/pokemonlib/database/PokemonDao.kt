package by.hometraining.pokemonlib.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import by.hometraining.pokemonlib.model.PokemonEntity

@Dao
internal interface PokemonDao {

    @Query("Select * FROM pokemonentity")
    suspend fun getPokemons(): List<PokemonEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertPokemons(pokemons: List<PokemonEntity>)
}