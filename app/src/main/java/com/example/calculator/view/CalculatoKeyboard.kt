package com.example.calculator.view

import android.content.res.Configuration
import android.widget.GridLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

data class ButtonData(val text: String, val onClick: ()->Unit = {})


@Composable
fun CalculatorKeyboard(buttons: List<ButtonData>) {

//    LazyRow(modifier = Modifier.fillMaxHeight()) {
//        items() { button ->
//            CalculatorButton(text = button.text, onButtonClick = button.onClick)
//        }
//    }
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            LazyVerticalGrid(columns = GridCells.Fixed(6)) {
                items(buttons) {
                        button -> CalculatorButton(text = button.text, onButtonClick = button.onClick)
                }
            }
        }
        else -> {
            LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                items(buttons) {
                        button -> CalculatorButton(text = button.text, onButtonClick = button.onClick)
                }
            }
        }
    }

//    Column {
//        buttons.forEach {
//            button -> CalculatorButton(text = button.text, button.onClick)
//        }
//    }
//
//    LazyVerticalGrid(columns = GridCells.) {
//        items(buttons) {
//            button -> CalculatorButton(text = button.text, onButtonClick = button.onClick)
//        }
//    }

}

