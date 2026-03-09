package com.example.composepokedex.dummies

import com.example.composepokedex.R
import com.example.composepokedex.domain.Pokemon

val pokemonList = listOf(
    Pokemon(
        "Bulbasaur",
        1,
        "Grass/Poison",
        "There is a plant seed on its back from the day this Pokémon is born.",
        0.7f,
        6.9f,
        false,
        "Overgrow",
        R.drawable.bulbasaur
    ),

    Pokemon(
        "Charmander",
        4,
        "Fire",
        "The flame on its tail shows the strength of its life force.",
        0.6f,
        8.5f,
        true,
        "Blaze",
        R.drawable.charmander
    ),

    Pokemon(
        "Squirtle",
        7,
        "Water",
        "After birth, its back swells and hardens into a shell.",
        0.5f,
        9.0f,
        false,
        "Torrent",
        R.drawable.squirtle
    ),

    Pokemon(
        "Pikachu",
        25,
        "Electric",
        "When several of these Pokémon gather, their electricity could build and cause lightning storms.",
        0.4f,
        6.0f,
        true,
        "Static",
        R.drawable.pikachu,
        evolutions = listOf(
            Pokemon(
                "Pichu",
                172, "Electric",
                "It is unskilled at storing electric power. Any kind of shock causes it to discharge energy spontaneously.",
                0.3f,
                2.0f,
                false,
                "Static",
                R.drawable.pichu
            ),

            Pokemon(
                "Raichu",
                26,
                "Electric",
                "When its electricity builds, its muscles are stimulated, and it becomes more aggressive than usual.",
                0.8f,
                30.0f,
                false,
                "Static",
                R.drawable.raichu
            )
        )
    ),

    Pokemon(
        "Pichu",
        172, "Electric",
        "It is unskilled at storing electric power. Any kind of shock causes it to discharge energy spontaneously.",
        0.3f,
        2.0f,
        false,
        "Static",
        R.drawable.pichu
    ),

    Pokemon(
        "Raichu",
        26,
        "Electric",
        "When its electricity builds, its muscles are stimulated, and it becomes more aggressive than usual.",
        0.8f,
        30.0f,
        false,
        "Static",
        R.drawable.raichu
    ),

    Pokemon(
        "Jigglypuff",
        39,
        "Fairy",
        "Uses its alluring eyes to enrapture its foe, then sings a pleasant melody to lull them to sleep.",
        0.5f,
        5.5f,
        false,
        "Cute Charm",
        R.drawable.jigglypuff
    ),

    Pokemon(
        "Gengar",
        94,
        "Ghost",
        "Under a full moon, this Pokémon likes to mimic the shadows of people and laugh at their fright.",
        1.5f,
        40.5f,
        true,
        "Cursed Body",
        R.drawable.gengar
    ),

    Pokemon(
        "Snorlax",
        143,
        "Normal",
        "Its stomach is said to be so strong that it can even eat moldy or rotten food.",
        2.1f,
        460.0f,
        false,
        "Immunity",
        R.drawable.snorlax
    ),

    Pokemon(
        "Mewtwo",
        150,
        "Psychic",
        "It was created by a scientist after years of horrific gene-splicing and DNA engineering experiments.",
        2.0f,
        122.0f,
        true,
        "Pressure",
        R.drawable.mewtwo
    ),

    Pokemon(
        "Lucario",
        448,
        "Fighting",
        "By catching the aura emanating from others, it can read their thoughts and movements.",
        1.2f,
        54.0f,
        true,
        "Steadfast",
        R.drawable.lucario
    ),

    Pokemon(
        "Mimikyu",
        778,
        "Ghost",
        "Its actual appearance is unknown. A scholar who saw what was under its rag overwhelmed by terror and died.",
        0.2f,
        0.7f,
        false,
        "Disguise",
        R.drawable.mimikyu
    )
)

fun showAllPokemons(): List<Pokemon> {
    return pokemonList
}

fun getOnePokemon(): Pokemon {
    return pokemonList.get((0..9).random())
}

fun getPokemon(id: Int):Pokemon{
    return pokemonList.filter { pokemon ->  pokemon.number == id }.get(0)
}