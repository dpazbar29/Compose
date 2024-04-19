package ejercicioExtra

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Suppress("ktlint:standard:function-naming")
@Composable
@Preview
fun App() {
    var count by remember { mutableStateOf(0) }
    var primerClic by remember { mutableStateOf(true) }

    MaterialTheme {
        Column {
            Button(onClick = {
                count++
                primerClic = false
            }) {
                Text(if (count == 0) "Empezar" else "Contador: $count")
            }

            Button(onClick = { count = 0 }) {
                Text("Resetear")
            }
        }
    }
}

fun main() =
    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
