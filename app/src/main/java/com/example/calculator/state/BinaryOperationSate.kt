package com.example.calculator.state

import com.example.calculator.model.Repository

class BinaryOperationSate(private val app: App, private val repo: Repository) : State {
    override fun onDigitInputEvent(digit: Char) {
        if (repo.getOperator() == "/" && digit == '0') {
            app.warn("Div/0")
        }
        repo.appendDigitToSecondNumber(digit)
        app.changeState(SecondNumberInputState(app, repo))
    }

    override fun onUnaryOperatorInputEvent(operator: String) {

    }

    override fun onBinaryOperatorInputEvent(operator: String) {
        repo.setOperator(operator)
    }

    override fun onEqualsEvent() {

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