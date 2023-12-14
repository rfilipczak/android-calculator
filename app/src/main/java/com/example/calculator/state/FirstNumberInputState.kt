package com.example.calculator.state

import com.example.calculator.model.Repository

class FirstNumberInputState(private val app: App, private val repo: Repository) : State {
    private var _commaInserted = false

    override fun onDigitInputEvent(digit: Char) {
        repo.appendDigitToFirstNumber(digit)
    }

    override fun onUnaryOperatorInputEvent(operator: String) {
        repo.setOperator(operator)
        app.changeState(UnaryOperationState(app, repo))
    }

    override fun onBinaryOperatorInputEvent(operator: String) {
        repo.setOperator(operator)
        app.changeState(BinaryOperationSate(app, repo))
    }

    override fun onEqualsEvent() {

    }

    override fun onClearEvent() {
        repo.clear()
        app.changeState(StartState(app, repo))
    }

    override fun onCommaEvent() {
        if (!_commaInserted) {
            repo.appendDigitToFirstNumber('.')
            _commaInserted = true
        }
    }

    override fun onSignEvent() {
        repo.toggleFirstNumberSign()
    }

    override fun onCEEvent() {
        repo.clear()
        app.changeState(StartState(app, repo))
    }

    override fun getNumberToDisplay(): String {
        return repo.getFirstNumber()
    }
}