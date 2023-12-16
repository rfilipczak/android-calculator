package com.example.calculator.state

import com.example.calculator.viewmodel.Calculator
import com.example.calculator.model.Repository

class ResultState(private val app: App, private val repo: Repository) : State {
    override fun onDigitInputEvent(digit: Char) {
        repo.clear()
        repo.appendDigitToFirstNumber(digit)
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
    }

    override fun onBinaryOperatorInputEvent(operator: String) {
        val result = repo.getResult()
        repo.clear()
        repo.setFirstNumber(result)
        repo.setOperator(operator)
        app.changeState(BinaryOperationSate(app, repo))
    }

    override fun onEqualsEvent() {
//        var result = Calculator.calculate(repo.getResult(), repo.getOperator(), repo.getSecondNumber()).toString()
//        if (result == "Infinity" || result == "-Infinity" || result == "NaN") {
//            result = "0.0"
//        }
//        repo.setResult(result)
//        repo.setFirstNumber(result)
//        app.changeState(ResultState(app, repo))
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

    }

    override fun onSignEvent() {
        val result = repo.getResult()
        repo.clear()
        repo.setFirstNumber(result)
        repo.toggleFirstNumberSign()
        app.changeState(FirstNumberInputState(app, repo))
    }

    override fun onCEEvent() {
        repo.clear()
        app.changeState(StartState(app, repo))
    }

    override fun getNumberToDisplay(): String {
        return repo.getResult()
    }
}