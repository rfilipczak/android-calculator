package com.example.calculator.state

import com.example.calculator.model.Repository

class UnaryOperationState(private val app: App, private val repo: Repository) : State {
    override fun onDigitInputEvent(digit: Char) {

    }

    override fun onUnaryOperatorInputEvent(operator: String) {

    }

    override fun onBinaryOperatorInputEvent(operator: String) {

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