package by.hometrainng.pokemonlib.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDTO(
    val id: Int,
    val name: String,
    val types: List<Types>,
    val weight: Int,
    val height: Int,
    @SerializedName("sprites") // TODO проверить правильность доступа к параметру
    val imageURL: Sprites
) {
    data class Types(
        @SerializedName("type")
        val type: Type
    ) {
        data class Type(
            var name : String
        )
    }
    data class Sprites(
        @SerializedName("front_default")
        val frontDefaultAvatarURL: String
    )
}

/*
data class ExampleJson2KtKotlin (

    @SerializedName("height"                   ) var height                 : Int?                   = null,
    @SerializedName("id"                       ) var id                     : Int?                   = null,
    @SerializedName("name"                     ) var name                   : String?                = null,
    @SerializedName("sprites"                  ) var sprites                : Sprites?               = Sprites(),
    @SerializedName("types"                    ) var types                  : ArrayList<Types>       = arrayListOf(),
    @SerializedName("weight"                   ) var weight                 : Int?                   = null

)

data class Types (

    @SerializedName("slot" ) var slot : Int?  = null,
    @SerializedName("type" ) var type : Type? = Type()

)

data class Type (

    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)

data class Sprites (

    @SerializedName("front_default"      ) var frontDefault     : String?   = null,

)*/
