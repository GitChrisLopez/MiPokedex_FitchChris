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
import com.example.composepokedex.ui.theme.*


@Composable
fun LoginScreen(onLoginSuccess: () -> Unit,
                onNavigateToRegister: () -> Unit) {

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

        Text("Inicio de Sesion",
            style = MaterialTheme.typography.headlineLarge,
            color = DarkGray)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onLoginSuccess, modifier = Modifier.fillMaxWidth()) {
            Text("Iniciar Sesion")
        }

        TextButton(onClick = onNavigateToRegister) {
            Text("¿No tienes cuenta? ",
                color = DarkGray)
            Text("Regístrate",
                color = Water,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposePokedexTheme {
        LoginScreen(onLoginSuccess = {},
            onNavigateToRegister = {})
    }
}