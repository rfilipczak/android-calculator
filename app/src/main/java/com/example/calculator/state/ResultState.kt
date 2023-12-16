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

    }

    override fun onBinaryOperatorInputEvent(operator: String) {
        val result = repo.getResult()
        repo.clear()
        repo.setFirstNumber(result)
        repo.setOperator(operator)
        app.changeState(BinaryOperationSate(app, repo))
    }

    override fun onEqualsEvent() {
        val result = Calculator.calculate(repo.getResult(), repo.getOperator(), repo.getSecondNumber()).toString()
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