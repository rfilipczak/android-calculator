package com.example.calculator.state

import com.example.calculator.model.Repository
import com.example.calculator.viewmodel.Calculator

class UnaryOperationState(private val app: App, private val repo: Repository) : State {
    override fun onDigitInputEvent(digit: Char) {

    }

    override fun onUnaryOperatorInputEvent(operator: String) {

    }

    override fun onBinaryOperatorInputEvent(operator: String) {

    }

    override fun onEqualsEvent() {
        val result = Calculator.calculate(repo.getFirstNumber(), repo.getOperator(), repo.getSecondNumber()).toString()
        repo.setResult(result)
        repo.setFirstNumber(result)
        app.changeState(ResultState(app, repo))
    }

    override fun onClearEvent() {
        repo.clear()
        app.changeState(StartState(app, repo))
    }

    override fun onCommaEvent() {

    }

    override fun onSignEvent() {

    }

    override fun onCEEvent() {

    }

    override fun getNumberToDisplay(): String {
        return repo.getFirstNumber()
    }
}