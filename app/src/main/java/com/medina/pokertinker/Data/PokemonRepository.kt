package com.medina.pokertinker.Data

import com.medina.pokertinker.Data.model.PokemonListModel
import com.medina.pokertinker.Data.model.PokemonModel
import com.medina.pokertinker.Data.network.PokemonService
import com.medina.pokertinker.domain.model.Pokemon
import com.medina.pokertinker.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }

    }
}