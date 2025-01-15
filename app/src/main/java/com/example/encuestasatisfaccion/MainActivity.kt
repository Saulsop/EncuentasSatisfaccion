package com.example.encuestasatisfaccion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.encuestasatisfaccion.ui.theme.EncuestaSatisfaccionTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.*

import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EncuestaSatisfaccionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Estados para manejar los valores de los campos
    var satisfactionValue by remember { mutableStateOf(0f) }
    var comentarios by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Nombre")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Nivel de satisfaccion")
        Slider(
            value = satisfactionValue,
            onValueChange = { satisfactionValue = it },
            valueRange = 4f..5f,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "comentarios")
        OutlinedTextField(
            value = comentarios,
            onValueChange = { comentarios = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            maxLines = 4
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EncuestaSatisfaccionTheme {
        Greeting("Android")
    }
}