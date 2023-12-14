package com.example.calculator.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

class AdvancedCalculatorActivity : ComponentActivity() {
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
                    AdvancedCalculator(calculatorViewModel)
                }
            }
        }
    }
}

@Composable
fun AdvancedCalculator(viewModel: CalculatorViewModel) {
    val advancedButtons = listOf(
        ButtonData("Sin"),
        ButtonData("Cos"),
        ButtonData("Tan"),
        ButtonData("Ln"),
        ButtonData("Log"),
        ButtonData("%"),
        ButtonData("Sqrt"),
        ButtonData("x^2"),
        ButtonData("x^y")
    )
    val operatorButtons = listOf(
        ButtonData("AC") { viewModel.onACButtonClick() },
        ButtonData("C/CE") { viewModel.onCEButtonClick() },
        ButtonData("+/-") { viewModel.onSignButtonClick() },
        ButtonData("/") { viewModel.onBinaryOperatorButtonClick("/") },
        ButtonData("x") { viewModel.onBinaryOperatorButtonClick("x") },
        ButtonData("-") { viewModel.onBinaryOperatorButtonClick("-") },
        ButtonData("+") { viewModel.onBinaryOperatorButtonClick("+")},
        ButtonData("=") { viewModel.onEqualsButtonClick() },
    )
    val digitButtons = listOf(
        ButtonData("7") { viewModel.onDigitButtonClick('7') },
        ButtonData("8") { viewModel.onDigitButtonClick('8') },
        ButtonData("9") { viewModel.onDigitButtonClick('9') },
        ButtonData("4") { viewModel.onDigitButtonClick('4') },
        ButtonData("5") { viewModel.onDigitButtonClick('5') },
        ButtonData("6") { viewModel.onDigitButtonClick('6') },
        ButtonData("1") { viewModel.onDigitButtonClick('1') },
        ButtonData("2") { viewModel.onDigitButtonClick('2') },
        ButtonData("3") { viewModel.onDigitButtonClick('3') },
        ButtonData("0") { viewModel.onDigitButtonClick('0') },
        ButtonData(".") { viewModel.onCommaButtonClick() },
        ButtonData("")
    )
    val baseButtons = listOf(
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
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Top) {


        Text(text = viewModel.result.value, textAlign = TextAlign.Right, modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .weight(0.2f),
            style = MaterialTheme.typography.headlineLarge
        )

        Box(modifier = Modifier.weight(0.8f).fillMaxSize()) {
            AdvancedCalculatorKeyboard(digitButtons, operatorButtons, advancedButtons, baseButtons)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AdvancedCalculatorPreview() {
    AdvancedCalculator(CalculatorViewModel())
}