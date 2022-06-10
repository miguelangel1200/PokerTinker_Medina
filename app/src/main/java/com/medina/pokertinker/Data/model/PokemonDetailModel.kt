package com.medina.pokertinker.Data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailModel(
    @SerializedName("count") val id: Int,
    @SerializedName("count") val base_experience: Int,
    @SerializedName("count") val height: Int,
    @SerializedName("count") val weight: Int,
    @SerializedName("count") val stats: List<Stats>,
    @SerializedName("count") val types: List<Types>,
    @SerializedName("count") val abilities: List<Abilities>
) {
    data class Stats(
        val base_stat: Int,
        val stat: Stat
    ) {
        data class Stat(
            val name: String
        )
    }

    data class Types(
        val type: Type
    ) {
        data class Type(
            val name: String
        )
    }

    data class Abilities(
        val ability: Ability
    ) {
        data class Ability(
            val name: String
        )
    }
}
