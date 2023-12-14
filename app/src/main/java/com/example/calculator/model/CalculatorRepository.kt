package com.example.calculator.model

class CalculatorRepository : Repository {

    private var _result = "0"
    private var _firstNumber = "0"
    private var _secondNumber = "0"
    private var _operator = "+"

    override fun clear() {
        _result = "0"
        _firstNumber = "0"
        _secondNumber = "0"
        _operator = "+"
    }

    override fun appendDigitToFirstNumber(digit: Char) {
        if (_firstNumber.startsWith("0")) {
            _firstNumber = ""
        }
        _firstNumber += digit
        _result = getFirstNumber()
    }

    override fun appendDigitToSecondNumber(digit: Char) {
        if (_secondNumber.startsWith("0")) {
            _secondNumber = ""
        }
        _secondNumber += digit
        _result = getSecondNumber()
    }

    override fun setOperator(operator: String) {
        _operator = operator
    }

    override fun getResult(): String {
        return _result
    }

    override fun setResult(result: String) {
        _result = result
    }

    override fun getFirstNumber(): String {
        return _firstNumber
    }

    override fun getSecondNumber(): String {
        return _secondNumber
    }

    override fun getOperator(): String {
        return _operator
    }

    override fun setFirstNumber(number: String) {
        _firstNumber = number
    }

    override fun setSecondNumber(number: String) {
        _secondNumber = number
    }

    private fun toggleSign(number: String): String {
        if (number.startsWith("-")) {
            return number.substring(1)
        } else {
            return "-$number"
        }
    }

    override fun toggleFirstNumberSign() {
        _firstNumber = toggleSign(_firstNumber)
    }

    override fun toggleSecondNumberSign() {
        _secondNumber = toggleSign(_secondNumber)
    }
}