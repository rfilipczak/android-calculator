package com.example.calculator.state

import com.example.calculator.model.Repository
import com.example.calculator.viewmodel.Calculator

class FirstNumberInputState(private val app: App, private val repo: Repository) : State {
    private var _commaInserted = false

    override fun onDigitInputEvent(digit: Char) {
        repo.appendDigitToFirstNumber(digit)
    }

    override fun onUnaryOperatorInputEvent(operator: String) {
        repo.setOperator(operator)
        var result = Calculator.calculate(repo.getFirstNumber(), repo.getOperator(), repo.getSecondNumber()).toString()
        if (result == "Infinity" || result == "-Infinity" || result == "NaN") {
            result = "0.0"
        }
        repo.setResult(result)
        repo.setFirstNumber(result)
        app.changeState(ResultState(app, repo))
//        app.changeState(UnaryOperationState(app, repo))
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
        repo.addCommaToFirstNumber()
//        if (!_commaInserted) {
//            repo.appendDigitToFirstNumber('.')
//            _commaInserted = true
//        }
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