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

// Lifted from https://stackoverflow.com/questions/58743541/how-to-get-context-in-jetpack-compose
open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
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
    private val _result = mutableStateOf(_repository.getResult())
    private var _state: State = StartState(this, _repository)
    private val statusMessage = MutableLiveData<Event<String>>()

    val result: MutableState<String> = _result
    val message : LiveData<Event<String>>
        get() = statusMessage

    fun onDigitButtonClick(digit: Char) {
        _state.onDigitInputEvent(digit)
        _result.value = _repository.getResult()
    }

    fun onCommaButtonClick() {
        _state.onCommaEvent()
        _result.value = _repository.getResult()
    }

    fun onACButtonClick() {
        _state.onClearEvent()
        _result.value = _repository.getResult()
    }

    fun onBinaryOperatorButtonClick(operator: String) {
        _state.onBinaryOperatorInputEvent(operator)
    }

    fun onSignButtonClick() {
        _state.onSignEvent()
        _result.value = _repository.getResult()
    }

    fun onEqualsButtonClick() {
        _state.onEqualsEvent()
        _result.value = _repository.getResult()
    }

    fun onCEButtonClick() {
        _state.onCEEvent()
        _result.value = _repository.getResult()
    }

    override fun changeState(state: State) {
        _state = state
    }

    override fun warn(text: String) {
        statusMessage.value = Event(text)
    }
}