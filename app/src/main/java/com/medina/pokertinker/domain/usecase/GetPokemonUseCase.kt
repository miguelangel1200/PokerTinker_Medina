package com.medina.pokertinker.domain.usecase

import com.medina.pokertinker.Data.PokemonRepository
import com.medina.pokertinker.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(private val repository: PokemonRepository){
    suspend operator fun invoke():List<Pokemon> {
        return repository.getAllPokemonFromApi()
    }
}