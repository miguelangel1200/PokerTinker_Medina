package com.medina.pokertinker.domain.usecase

import com.medina.pokertinker.Data.PokemonRepository
import com.medina.pokertinker.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    suspend operator fun invoke(): List<MyPokemon>{
        return pokemonRepository.getMyPokemonsFromDatabase()
    }
}