package by.hometrainng.pokemonlib.converter

import java.util.*

class TypeConverter {

    @androidx.room.TypeConverter
    public fun listToString(typesList: List<String>): String {
        return typesList.joinToString(SEPARATOR)
    }

    @androidx.room.TypeConverter
    public fun stringToList(typesString: String): List<String> {
        return typesString.split(SEPARATOR).toTypedArray().asList()
    }

    companion object {
        private const val SEPARATOR = ","
    }
}