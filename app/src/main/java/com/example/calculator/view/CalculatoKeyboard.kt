package com.example.calculator.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration

data class ButtonData(val text: String, val onClick: ()->Unit = {})

@Composable
fun CalculatorKeyboard(buttons: List<ButtonData>, digits: List<ButtonData>, operators: List<ButtonData>) {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            BasicKeyboardLandscape(digits, operators)
        }
        else -> {
            LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                items(buttons) {
                        button -> CalculatorButton(text = button.text, onButtonClick = button.onClick)
                }
            }
        }
    }
}

@Composable
fun BasicKeyboardLandscape(
    digits: List<ButtonData>,
    operators: List<ButtonData>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            items(digits) { button ->
                CalculatorButton(text = button.text, onButtonClick = button.onClick)
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            items(operators) { button ->
                CalculatorButton(text = button.text, onButtonClick = button.onClick)
            }
        }
    }
}