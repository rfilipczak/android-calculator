package com.example.calculator.state

interface App {
    fun changeState(state: State)
    fun warn(text: String)
}