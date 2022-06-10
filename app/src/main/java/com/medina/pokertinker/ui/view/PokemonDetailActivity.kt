package com.medina.pokertinker.ui.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.medina.pokertinker.R

class PokemonDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        val pokemonId = intent?.extras?.getString("ID_POKEMON",null)

        if (pokemonId != null){
            Toast.makeText(this, "PokemonId: $pokemonId", Toast.LENGTH_SHORT).show()
        }
    }
}