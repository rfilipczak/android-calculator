package com.example.calculator.model

class CalculatorRepository : Repository {

    private var _result = "0"
    private var _firstNumber = "0"
    private var _secondNumber = ""
    private var _operator = ""
    private var _isFirstNumberNegative = false
    private var _isSecondNumberNegative = false

    override fun clear() {
        _result = "0"
        _firstNumber = "0"
        _secondNumber = ""
        _operator = ""
        _isFirstNumberNegative = false
        _isSecondNumberNegative = false
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

    override fun removeDigitFromFirstNumber() {
        _firstNumber = _firstNumber.dropLast(1)
        _result = _firstNumber
    }

    override fun removeDigitFromSecondNumber() {
        _secondNumber = _secondNumber.dropLast(1)
        _result = _secondNumber
    }

    override fun setResult(result: String) {
        _result = result
    }

    override fun getFirstNumber(): String {
        return (if (_isFirstNumberNegative) "-" else "") + _firstNumber
    }

    override fun getSecondNumber(): String {
        return (if (_isSecondNumberNegative) "-" else "") + _secondNumber
    }

    override fun getOperator(): String {
        return _operator
    }

    override fun setFirstNumber(number: String) {
        _firstNumber = number
        _result = getFirstNumber()
    }

    override fun setSecondNumber(number: String) {
        _secondNumber = number
        _result = getSecondNumber()
    }

    override fun toggleFirstNumberSign() {
        _isFirstNumberNegative = !_isFirstNumberNegative
        _result = getFirstNumber()
    }

    override fun toggleSecondNumberSign() {
        _isSecondNumberNegative = !_isSecondNumberNegative
        _result = getSecondNumber()
    }

    override fun setSecondNumberSign(sign: Boolean) {
        _isSecondNumberNegative = sign
        _result = getSecondNumber()
    }
}