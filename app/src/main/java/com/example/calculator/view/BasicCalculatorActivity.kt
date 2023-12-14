package com.example.calculator.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.viewmodel.CalculatorViewModel

class BasicCalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val calculatorViewModel: CalculatorViewModel = viewModel()

            calculatorViewModel.message.observe(this, Observer { it ->
                it.getContentIfNotHandled()?.let {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
            })

            CalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicCalculator(calculatorViewModel)
                }
            }
        }
    }
}

@Composable
fun BasicCalculator(viewModel: CalculatorViewModel) {
    val buttons = listOf(
        ButtonData("AC") { viewModel.onACButtonClick() },
        ButtonData("C/CE") { viewModel.onCEButtonClick() },
        ButtonData("+/-") { viewModel.onSignButtonClick() },
        ButtonData("/") { viewModel.onBinaryOperatorButtonClick("/") },
        ButtonData("7") { viewModel.onDigitButtonClick('7') },
        ButtonData("8") { viewModel.onDigitButtonClick('8') },
        ButtonData("9") { viewModel.onDigitButtonClick('9') },
        ButtonData("x") { viewModel.onBinaryOperatorButtonClick("x") },
        ButtonData("4") { viewModel.onDigitButtonClick('4') },
        ButtonData("5") { viewModel.onDigitButtonClick('5') },
        ButtonData("6") { viewModel.onDigitButtonClick('6') },
        ButtonData("-") { viewModel.onBinaryOperatorButtonClick("-") },
        ButtonData("1") { viewModel.onDigitButtonClick('1') },
        ButtonData("2") { viewModel.onDigitButtonClick('2') },
        ButtonData("3") { viewModel.onDigitButtonClick('3') },
        ButtonData("+") { viewModel.onBinaryOperatorButtonClick("+")},
        ButtonData("0") { viewModel.onDigitButtonClick('0') },
        ButtonData(".") { viewModel.onCommaButtonClick() },
        ButtonData(""),
        ButtonData("=") { viewModel.onEqualsButtonClick() },
    )
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = viewModel.result.value, textAlign = TextAlign.Right, modifier = Modifier.fillMaxWidth().padding(16.dp))
        Spacer(modifier = Modifier.size(16.dp))
        CalculatorKeyboard(buttons)
    }
}

@Preview(showBackground = true)
@Composable
fun BasicCalculatorPreview() {
    BasicCalculator(CalculatorViewModel())
}