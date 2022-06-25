package com.medina.pokertinker.domain.usecase

import com.medina.pokertinker.Data.PokemonRepository
import javax.inject.Inject

class DeleteAllMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(){
        pokemonRepository.deleteAllMyPokemon()
    }
}