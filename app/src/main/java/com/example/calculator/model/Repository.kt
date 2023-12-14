package com.example.calculator.model

interface Repository {
    fun clear()
    fun appendDigitToFirstNumber(digit: Char)
    fun appendDigitToSecondNumber(digit: Char)
    fun setOperator(operator: String)
    fun getResult(): String
    fun removeDigitFromFirstNumber()
    fun removeDigitFromSecondNumber()
    fun setResult(result: String)
    fun getFirstNumber(): String
    fun getSecondNumber(): String
    fun getOperator(): String
    fun setFirstNumber(number: String)
    fun setSecondNumber(number: String)
    fun toggleFirstNumberSign()
    fun toggleSecondNumberSign()
    fun setSecondNumberSign(sign: Boolean)
}