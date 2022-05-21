package com.medina.pokertinker.domain.model

import com.medina.pokertinker.Data.model.PokemonModel
import java.io.Serializable
import com.medina.pokertinker.Util.getItPokemonFromUrl

data class Pokemon(
    val name: String,
    val url: String
) : Serializable {
    fun getPokemonId() = getItPokemonFromUrl(url)

    fun getPokemonImage(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
}

fun PokemonModel.toDomain() = Pokemon(name = name, url = url)
