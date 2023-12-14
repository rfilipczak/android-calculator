package com.example.calculator.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun AdvancedCalculatorKeyboard(
    digits: List<ButtonData>,
    operators: List<ButtonData>,
    advanced: List<ButtonData>,
    basic: List<ButtonData>
) {

    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            AdvancedKeyboardLandscape(digits, operators, advanced, basic)
        }

        else -> {
            Column(modifier = Modifier.fillMaxHeight()) {
                LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                    items(advanced) { button ->
                        CalculatorButton(text = button.text, onButtonClick = button.onClick)
                    }
                }
                LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                    items(basic) { button ->
                        CalculatorButton(text = button.text, onButtonClick = button.onClick)
                    }
                }
            }
        }
    }
}

@Composable
fun AdvancedKeyboardLandscape(
    digits: List<ButtonData>,
    operators: List<ButtonData>,
    advanced: List<ButtonData>,
    basic: List<ButtonData>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            items(advanced) { button ->
                CalculatorButton(text = button.text, onButtonClick = button.onClick)
            }
        }
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