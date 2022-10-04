package by.hometraining.pokemonlib.converter

//@ProvidedTypeConverter
class TypeConverter {

    @androidx.room.TypeConverter
    fun listToString(typesList: List<String>): String {
        return typesList.joinToString(SEPARATOR)
    }

    @androidx.room.TypeConverter
    fun stringToList(typesString: String): List<String> {
        return typesString.split(SEPARATOR).toTypedArray().asList()
    }

    companion object {
        private const val SEPARATOR = ","
    }
}