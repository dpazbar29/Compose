import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.key.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication

fun main() =
    singleWindowApplication {
        Column {
            repeat(5) {
                var text by remember { mutableStateOf("Hello, World!") }

                OutlinedTextField(
                    value = text,
                    singleLine = false, // Pay attention here! Also, by default, singleLine is false.
                    onValueChange = { text = it },
                    modifier = Modifier.padding(8.dp).moveFocusOnTab(),
                )
            }
        }
    }

// Gracias a la siguiente función se puede tabular entre campos multitexto
@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.moveFocusOnTab() =
    composed {
        val focusManager = LocalFocusManager.current
        onPreviewKeyEvent {
            if (it.type == KeyEventType.KeyDown && it.key == Key.Tab) {
                focusManager.moveFocus(
                    if (it.isShiftPressed) FocusDirection.Previous else FocusDirection.Next,
                )
                true
            } else {
                false
            }
        }
    }
