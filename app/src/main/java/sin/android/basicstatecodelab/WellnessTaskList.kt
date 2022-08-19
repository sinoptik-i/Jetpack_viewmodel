package sin.android.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            list,
            //key={task -> task.id }
            key = { it.id }
        ) {
            WellnessTaskItem(
                taskName = it.label,
                onClose = { onCloseTask(it) },
                checked=it.checked,
                onCheckedChange ={checked -> onCheckedTask(it, checked)})
            //нихуя не понятно, но очень интересно.
        }
    }
}