package com.medina.pokertinker.Data.network

import com.medina.pokertinker.Data.model.PokemonListModel
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("?limit=20")
    suspend fun getPokemons() : Response<PokemonListModel>
}