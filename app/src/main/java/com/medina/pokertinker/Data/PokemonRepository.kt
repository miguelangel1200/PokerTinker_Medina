package com.medina.pokertinker.Data

import com.medina.pokertinker.Data.dao.PokemonDao
import com.medina.pokertinker.Data.entities.MyPokemonEntity
import com.medina.pokertinker.domain.model.MyPokemon
import com.medina.pokertinker.Data.model.PokemonListModel
import com.medina.pokertinker.Data.model.PokemonModel
import com.medina.pokertinker.Data.network.PokemonService
import com.medina.pokertinker.domain.model.Pokemon
import com.medina.pokertinker.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }

    suspend fun getMyPokemonsFromDatabase(): List<MyPokemon> {
        val response: List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map { it.toDomain() }
    }

    suspend fun insertMyPokemon(myPokemon: MyPokemonEntity){
        pokemonDao.insert(myPokemon)
    }
}
