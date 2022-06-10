package com.medina.pokertinker.domain.usecase

import com.medina.pokertinker.Data.PokemonRepository
import com.medina.pokertinker.Data.entities.toDatabase
import com.medina.pokertinker.domain.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    suspend operator fun invoke(myPokemon: MyPokemon){
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }
}