package com.example.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepokedex.components.PokemonHeader
import com.example.composepokedex.domain.Pokemon
import com.example.composepokedex.navigation.MyApp
import com.example.composepokedex.screens.PokemonDetailScreen
import com.example.composepokedex.ui.theme.ComposePokedexTheme

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon("Pikachu", 25,
        "Electrico","gdfgdgdgfhfghfghfhf",
        0.4f, 6f, true,
        "Estatica", R.drawable.pikachu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                MyApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHeaderPreview(){
    ComposePokedexTheme() {
        PokemonHeader("Pikachu", 25, true)
    }
}