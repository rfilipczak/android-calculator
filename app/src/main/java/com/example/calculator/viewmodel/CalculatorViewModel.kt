package com.example.calculator.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.model.CalculatorRepository
import com.example.calculator.state.App
import com.example.calculator.state.StartState
import com.example.calculator.state.State

open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

class CalculatorViewModel : ViewModel(), App {
    private val _repository = CalculatorRepository()
    private var _state: State = StartState(this, _repository)
    private val _result = mutableStateOf(_state.getNumberToDisplay())
    private val _statusMessage = MutableLiveData<Event<String>>()

    val result: MutableState<String> = _result
    val message : LiveData<Event<String>>
        get() = _statusMessage

    fun onDigitButtonClick(digit: Char) {
        _state.onDigitInputEvent(digit)
        _result.value = _state.getNumberToDisplay()
    }

    fun onCommaButtonClick() {
        _state.onCommaEvent()
        _result.value = _state.getNumberToDisplay()
    }

    fun onACButtonClick() {
        _state.onClearEvent()
        _result.value = _state.getNumberToDisplay()
    }

    fun onBinaryOperatorButtonClick(operator: String) {
        _state.onBinaryOperatorInputEvent(operator)
    }

    fun onUnaryOperatorButtonClick(operator: String) {
        _state.onUnaryOperatorInputEvent(operator)
        _result.value = _state.getNumberToDisplay()
    }

    fun onSignButtonClick() {
        _state.onSignEvent()
        _result.value = _state.getNumberToDisplay()
    }

    fun onEqualsButtonClick() {
        _state.onEqualsEvent()
        _result.value = _state.getNumberToDisplay()
    }

    fun onCEButtonClick() {
        _state.onCEEvent()
        _result.value = _state.getNumberToDisplay()
    }

    override fun changeState(state: State) {
        _state = state
    }

    override fun warn(text: String) {
        _statusMessage.value = Event(text)
    }
}