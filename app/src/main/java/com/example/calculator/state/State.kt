package com.example.calculator.state

interface State {
    fun onDigitInputEvent(digit: Char)
    fun onUnaryOperatorInputEvent(operator: String)
    fun onBinaryOperatorInputEvent(operator: String)
    fun onEqualsEvent()
    fun onClearEvent()
    fun onCommaEvent()
    fun onSignEvent()
    fun onCEEvent()
}