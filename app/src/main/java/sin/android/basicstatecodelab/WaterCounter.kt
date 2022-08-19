package sin.android.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(
        modifier.padding(16.dp)
    ) {
        var count by remember { mutableStateOf(0) }
        if (count > 0) {
            /* var showTask by remember { mutableStateOf(true) }
             if (showTask) {
                 WellnessTaskItem(
                     onClose = { showTask = false },
                     taskName = "Have you taken your 15 minute walk today?"
                 )
             }*/
            Text("You've Had $count glasses")
        }
        Row(Modifier.padding(8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 5
            ) {
                Text(text = "Add one")
            }
            Button(
                onClick = { count = 0 },
                modifier.padding(start = 8.dp)
            ) {
                Text("Clear water count")

            }
        }
    }
}


@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (count > 0) {
        Text("You've Had $count glasses")
    }
    Button(
        onClick = { onIncrement },
        enabled = count < 5
    ) {
        Text(text = "Add one")
    }


}


@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    StatelessCounter(count = count, onIncrement = { count++ }, modifier)
}
