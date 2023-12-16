package com.example.calculator.state

import com.example.calculator.model.Repository
import com.example.calculator.viewmodel.Calculator

class StartState(private val app: App, private val repo: Repository) : State {
    override fun onDigitInputEvent(digit: Char) {
        repo.setFirstNumber(digit.toString())
        app.changeState(FirstNumberInputState(app, repo))
    }

    override fun onUnaryOperatorInputEvent(operator: String) {
        if (operator == "Ln" && repo.getResult().startsWith("0")) {
            app.warn("Ln(0)!")
        }
        repo.setOperator(operator)
        var result = Calculator.calculate(repo.getFirstNumber(), repo.getOperator(), repo.getSecondNumber()).toString()
        if (result == "Infinity" || result == "-Infinity" || result == "NaN") {
            result = "0.0"
        }
        repo.setResult(result)
        repo.setFirstNumber(result)
        app.changeState(ResultState(app, repo))
    }

    override fun onBinaryOperatorInputEvent(operator: String) {

    }

    override fun onEqualsEvent() {

    }

    override fun onClearEvent() {

    }

    override fun onCommaEvent() {
        repo.addCommaToFirstNumber()
        app.changeState(FirstNumberInputState(app, repo))
    }

    override fun onSignEvent() {

    }

    override fun onCEEvent() {

    }

    override fun getNumberToDisplay(): String {
        return repo.getFirstNumber()
    }
}