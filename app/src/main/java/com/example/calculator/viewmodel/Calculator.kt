package com.example.calculator.viewmodel

class Calculator {
    companion object {
        fun calculate(firstNumber: String, operator: String, secondNumber: String = ""): Double {
            return when (operator) {
                "+" -> {
                    firstNumber.toDouble() + secondNumber.toDouble()
                }

                "-" -> {
                    firstNumber.toDouble() - secondNumber.toDouble()
                }

                "x" -> {
                    firstNumber.toDouble() * secondNumber.toDouble()
                }

                "/" -> {
                    firstNumber.toDouble() / secondNumber.toDouble()
                }

                else -> 0.0
            }
        }
    }
}