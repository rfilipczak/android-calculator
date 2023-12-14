package com.example.calculator.view

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CalculatorButton(text: String, onButtonClick: () -> Unit) {
    Button(
        onClick = { onButtonClick() },
    ) {
        Text(
            text = text,
        )
    }
}

