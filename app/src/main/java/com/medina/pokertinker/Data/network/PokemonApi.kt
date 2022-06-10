package com.medina.pokertinker.Data.network

import com.medina.pokertinker.Data.model.PokemonDetailModel
import com.medina.pokertinker.Data.model.PokemonListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("?limit=20")
    suspend fun getPokemons() : Response<PokemonListModel>

    @GET("{pokemon_id}")
    suspend fun getDetailPokemon(
        @Path("pokemon_id") pokemonId: String
    ): PokemonDetailModel
}