package com.medina.pokertinker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medina.pokertinker.domain.model.MyPokemon
import com.medina.pokertinker.domain.usecase.GetMyPokemonsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val getMyPokemonsUseCase: GetMyPokemonsUseCase
) : ViewModel(){
    val myPokemonList = MutableLiveData<List<MyPokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMyPokemonsUseCase()
            if (result.isNotEmpty()){
                myPokemonList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}