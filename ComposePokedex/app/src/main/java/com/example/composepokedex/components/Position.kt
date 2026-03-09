package com.example.composepokedex.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PkmPosition(
    position: String,
    image: Int,
    name: String,
    number: Int,
    modifier: Modifier = Modifier,
    onNavigate: () -> Unit) {

    Row(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onNavigate() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (position == "left") {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retroceder")
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 4.dp)
            ) {
                PkmImage(image = image, name = name)
                PkmName(name = name)
                PkmNumber(number = number)
            }
        } else if (position == "right") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 4.dp)
            ) {
                PkmImage(image = image, name = name)
                PkmName(name = name)
                PkmNumber(number = number)
            }

            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Avanzar")
        }
    }
}
