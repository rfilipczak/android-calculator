package com.example.calculator.viewmodel

import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan
import kotlin.math.*

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

                "Sin" -> {
                    sin(firstNumber.toDouble())
                }

                "Cos" -> {
                    cos(firstNumber.toDouble())
                }

                "Tan" -> {
                    tan(firstNumber.toDouble())
                }

                "Ln" -> {
                    ln(firstNumber.toDouble())
                }

                "Log" -> {
                    log(firstNumber.toDouble(), secondNumber.toDouble())
                }

                "%" -> {
                    firstNumber.toDouble() % secondNumber.toDouble()
                }

                "Sqrt" -> {
                    sqrt(firstNumber.toDouble())
                }

                "^2" -> {
                    firstNumber.toDouble().pow(2.0)
                }

                "^" -> {
                    firstNumber.toDouble().pow(secondNumber.toDouble())
                }

                else -> 0.0
            }
        }
    }
}