package com.example.calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.calculator.view.AdvancedCalculatorActivity
import com.example.calculator.view.BasicCalculatorActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, AdvancedCalculatorActivity::class.java))
    }
}

