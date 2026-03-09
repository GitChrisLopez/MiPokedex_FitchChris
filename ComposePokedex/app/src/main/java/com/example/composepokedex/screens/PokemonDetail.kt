package com.example.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.composepokedex.components.PokemonHeader
import com.example.composepokedex.R
import com.example.composepokedex.components.Ability
import com.example.composepokedex.components.Chip
import com.example.composepokedex.components.PkmPosition
import com.example.composepokedex.domain.Pokemon
import com.example.composepokedex.navigation.PokemonDetail
import com.example.composepokedex.ui.theme.ComposePokedexTheme
import com.example.composepokedex.ui.theme.ElectricYellow
import com.example.composepokedex.ui.theme.White

@Composable
fun PokemonCard(name:String,
                weight: Float,
                height: Float,
                description: String,
                ability: String,
                type: String,
                image: Int,
                prevPokemon: Pokemon?,
                nextPokemon: Pokemon?,
                onNavigate: (Int) -> Unit){

    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(image), contentDescription = name,
            Modifier.offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            Modifier.fillMaxWidth().fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {

            Column(Modifier.fillMaxWidth()) {
                Chip(
                    type, ElectricYellow, Modifier.padding(top = 70.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(.8f)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column() {
                    Ability("row", label = "Altura", "${height} m")
                    Ability("row", label = "Peso", "${weight} kg")
                }
                Ability("column", label = "Habilidad", ability)
            }

            Row(
                Modifier.fillMaxWidth(.8f)
                    .align(Alignment.CenterHorizontally)
                    .padding(25.dp)
            ) {
                Text(description)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
            ) {
                if (prevPokemon != null) {
                    PkmPosition(
                        position = "left",
                        image = prevPokemon.image,
                        name = prevPokemon.name,
                        number = prevPokemon.number,
                        onNavigate = { onNavigate(prevPokemon.number)}
                    )
                } else {
                    Box(Modifier.size(1.dp))
                }

                if (nextPokemon != null) {
                    PkmPosition(
                        position = "right",
                        image = nextPokemon.image,
                        name = nextPokemon.name,
                        number = nextPokemon.number,
                        onNavigate = { onNavigate(nextPokemon.number)}
                    )
                } else {
                    Box(Modifier.size(1.dp))
                }
            }
        }
    }
}

@Composable
fun PokemonDetailScreen(
    pokemon: Pokemon,
    pokemonNextPrev: Pair<Pokemon?, Pokemon?>,
    onNavigate: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(ElectricYellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
            PokemonCard(
                pokemon.name, pokemon.weight, pokemon.height, pokemon.description,
                pokemon.ability, pokemon.type, pokemon.image,
                pokemonNextPrev.first, pokemonNextPrev.second,
                onNavigate = onNavigate
            )
        }

        if (pokemon.evolutions.isNotEmpty()) {
            items(pokemon.evolutions) { evolution ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .background(Color.White, MaterialTheme.shapes.medium)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(evolution.image),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(Modifier.width(16.dp))
                    Text(evolution.name, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    ComposePokedexTheme {
        ComposePokedexTheme {
            val raichu = Pokemon(
                "Raichu",
                26,
                "Eléctrico",
                "fdgdfgdgf",
                0.8f,
                30f,
                false,
                "Estática",
                R.drawable.raichu
            )
            val pichu = Pokemon(
                "Pichu",
                172,
                "Eléctrico",
                "fdcszvfgdf",
                0.3f,
                2f,
                false,
                "Estática",
                R.drawable.pichu
            )

            val pikachu = Pokemon(
                "Pikachu", 25, "Eléctrico",
                "Cuando se enfurece, descarga energía...",
                0.4f, 6f, true, "Estática", R.drawable.pikachu,
                evolutions = listOf(pichu, raichu)
            )

            PokemonDetailScreen(
                pokemon = pikachu,
                pokemonNextPrev = Pair(pichu, raichu),
                onNavigate = { }
            )
        }
    }
}