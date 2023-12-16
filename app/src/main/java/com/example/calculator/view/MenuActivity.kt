package com.example.calculator.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat.finishAffinity
import com.example.calculator.ui.theme.CalculatorTheme

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Menu(this)
                }
            }
        }
    }
}


@Composable
fun Menu(activity: MenuActivity) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            context.startActivity(Intent(context, BasicCalculatorActivity::class.java))
        }) {
            Text("Basic")
        }
        Button(onClick = {
            context.startActivity(Intent(context, AdvancedCalculatorActivity::class.java))
        }) {
            Text("Advanced")
        }
        Button(onClick = {
            context.startActivity(Intent(context, InfoActivity::class.java))
        }) {
            Text("Info")
        }
        Button(onClick = { finishAffinity(activity) }) {
            Text("Exit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    Menu(MenuActivity())
}