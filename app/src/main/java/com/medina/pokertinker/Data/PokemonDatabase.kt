package com.medina.pokertinker.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.medina.pokertinker.Data.dao.PokemonDao
import com.medina.pokertinker.Data.entities.MyPokemonEntity


@Database(entities = [MyPokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao

}