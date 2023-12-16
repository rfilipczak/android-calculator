package com.example.calculator.state

import com.example.calculator.viewmodel.Calculator
import com.example.calculator.model.Repository

class SecondNumberInputState(private val app: App, private val repo: Repository) : State {
    private var _commaInserted = false

    override fun onDigitInputEvent(digit: Char) {
        repo.appendDigitToSecondNumber(digit)
    }

    override fun onUnaryOperatorInputEvent(operator: String) {

    }

    override fun onBinaryOperatorInputEvent(operator: String) {

    }

    override fun onEqualsEvent() {
        var error = false
        if (repo.getOperator() == "Log") {
            if (repo.getFirstNumber().toDouble() <= 0.0) {
                app.warn("Log(a, b) a must be > 0")
                repo.clear()
                app.changeState(StartState(app, repo))
                error = true
            } else if (repo.getFirstNumber().toDouble() == 1.0) {
                app.warn("Log(a, b) a must != 1")
                repo.clear()
                app.changeState(StartState(app, repo))
                error = true
            } else if (repo.getSecondNumber().toDouble() <= 0) {
                app.warn("Log(a, b) b must be > 0")
                repo.clear()
                app.changeState(StartState(app, repo))
                error = true
            }
        }

        if (error) {
            return
        }

        var result = Calculator.calculate(repo.getFirstNumber(), repo.getOperator(), repo.getSecondNumber()).toString()
        if (result == "Infinity" || result == "-Infinity" || result == "NaN") {
            result = "0.0"
        }
        repo.setResult(result)
        repo.setFirstNumber(result)
        app.changeState(ResultState(app, repo))
    }

    override fun onClearEvent() {
        repo.clear()
        app.changeState(StartState(app, repo))
    }

    override fun onCommaEvent() {
//        if (!_commaInserted) {
//            repo.appendDigitToSecondNumber('.')
//            _commaInserted = true
//        }
        repo.addCommaToSecondNumber()
    }

    override fun onSignEvent() {
        repo.toggleSecondNumberSign()
    }

    override fun onCEEvent() {
        if (repo.getSecondNumber() == "0" || repo.getSecondNumber() == "-0") {
            repo.clear()
            app.changeState(StartState(app, repo))
        } else {
            repo.setSecondNumber("0")
        }
    }

    override fun getNumberToDisplay(): String {
        return repo.getSecondNumber()
    }
}