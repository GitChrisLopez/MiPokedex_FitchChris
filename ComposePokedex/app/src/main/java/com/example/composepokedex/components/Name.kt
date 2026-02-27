package com.example.composepokedex.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PkmName(name: String, modifier: Modifier = Modifier) {
    Text(name)
}