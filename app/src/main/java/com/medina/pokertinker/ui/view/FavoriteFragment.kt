package com.medina.pokertinker.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.medina.pokertinker.databinding.FragmentFavoriteBinding
import com.medina.pokertinker.domain.model.MyPokemon
import com.medina.pokertinker.ui.adapter.MyPokemonsAdapter
import com.medina.pokertinker.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate){
    private var listMyPokemon = mutableListOf<MyPokemon>()
    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        binding.rvPokemons.adapter = adapter
        viewModel.myPokemonList.observe(this) {
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionDelete.setOnClickListener {
            viewModel.deleteAllPokemon()
            listMyPokemon.clear()
            adapter.notifyDataSetChanged()
        }
    }

}