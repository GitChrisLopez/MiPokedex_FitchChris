package com.example.composepokedex.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PkmNumber(number: Int, modifier: Modifier = Modifier) {
    Text("N.°${number}")
}