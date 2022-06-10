package com.medina.pokertinker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medina.pokertinker.domain.model.MyPokemon
import com.medina.pokertinker.domain.model.Pokemon
import com.medina.pokertinker.domain.usecase.GetPokemonUseCase
import com.medina.pokertinker.domain.usecase.SaveMyPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    private val saveMyPokemonUseCase: SaveMyPokemonUseCase
): ViewModel() {

    val pokemonList = MutableLiveData<List<Pokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonUseCase()
            pokemonList.postValue(result)
            isLoading.postValue(false)
        }
    }

    fun savePokemonUseCase(myPokemon: MyPokemon) {
        viewModelScope.launch {
            isLoading.postValue(true)
            saveMyPokemonUseCase.invoke(myPokemon)
            isLoading.postValue(false)
        }
    }
}