package com.example.calculator.state

import com.example.calculator.model.Repository

class StartState(private val app: App, private val repo: Repository) : State {
    override fun onDigitInputEvent(digit: Char) {
        repo.setFirstNumber(digit.toString())
        app.changeState(FirstNumberInputState(app, repo))
    }

    override fun onUnaryOperatorInputEvent(operator: String) {

    }

    override fun onBinaryOperatorInputEvent(operator: String) {

    }

    override fun onEqualsEvent() {

    }

    override fun onClearEvent() {

    }

    override fun onCommaEvent() {
        repo.appendDigitToFirstNumber('.')
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