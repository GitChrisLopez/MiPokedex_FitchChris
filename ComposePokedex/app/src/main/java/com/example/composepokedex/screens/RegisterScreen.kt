package com.example.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepokedex.R
import com.example.composepokedex.ui.theme.ComposePokedexTheme
import com.example.composepokedex.ui.theme.DarkGray
import com.example.composepokedex.ui.theme.Red
import com.example.composepokedex.ui.theme.Water

@Composable
fun RegisterScreen(onRegisterSuccess: () -> Unit,
                   onBackToLogin: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(painter = painterResource(R.drawable.pokedex),
            contentDescription = "pokedex",
            modifier = Modifier
                .size(150.dp)
                .padding(15.dp)
        )

        Text("Pokedex",
            style = MaterialTheme.typography.headlineLarge,
            color = Red,
            fontWeight = FontWeight.Bold)

        Text("Registro",
            style = MaterialTheme.typography.headlineLarge,
            color = DarkGray)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onRegisterSuccess, modifier = Modifier.fillMaxWidth()) {
            Text("Registrarse")
        }

        TextButton(onClick = onBackToLogin) {
            Text("Ya tengo una cuenta",
                color = Water,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    ComposePokedexTheme {
        RegisterScreen(onRegisterSuccess = {}, onBackToLogin = {})
    }
}