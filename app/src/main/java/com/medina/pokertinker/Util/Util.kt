package com.medina.pokertinker.Util

fun formatNumberTo3Digits(number: Int): String = "#${"%03d".format(number)}"

fun getItPokemonFromUrl(url: String): String = url.split("/").toTypedArray()[6]