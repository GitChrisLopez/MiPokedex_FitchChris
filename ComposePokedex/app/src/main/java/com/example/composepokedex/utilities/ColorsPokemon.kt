package com.example.composepokedex.utilities

import androidx.compose.ui.graphics.Color
import com.example.composepokedex.domain.Pokemon
import com.example.composepokedex.ui.theme.*

fun getColorByType(pokemon: Pokemon): Pair<Color, Color> {
    var color: Color = Normal
    var dark = true

    val type = pokemon.type.lowercase()

    when {
        type.contains("fire") -> color = Fire
        type.contains("water") -> color = Water

        type.contains("electric") -> {
            color = Electric
            dark = false
        }

        type.contains("grass") -> color = Grass
        type.contains("ice") -> {
            color = Ice
            dark = false
        }
        type.contains("fighting") -> color = Fight
        type.contains("poison") -> color = Poison
        type.contains("ground") -> color = Ground
        type.contains("flying") -> color = Flying
        type.contains("psychic") -> color = Psych
        type.contains("bug") -> color = Bug
        type.contains("rock") -> color = Rock
        type.contains("ghost") -> color = Ghost
        type.contains("dragon") -> color = Dragon
        type.contains("steel") -> {
            color = Steel
            dark = false
        }

        type.contains("dark") -> color = Dark
        type.contains("fairy") -> {
            color = Fairy
            dark = false
        }
        else -> color = Normal
    }

    val textColor = if (dark) OffWhite else DarkGray
    return Pair(color, textColor)
}