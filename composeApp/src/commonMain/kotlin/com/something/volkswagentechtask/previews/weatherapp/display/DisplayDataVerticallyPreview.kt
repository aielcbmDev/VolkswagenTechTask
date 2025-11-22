package com.something.volkswagentechtask.previews.weatherapp.display

import androidx.compose.runtime.Composable
import com.charly.weatherapp.ui.common.display.DisplayDataVertically
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun DisplayDataVerticallyPreview(
    title: String = "Title",
    data: String = "Data"
) {
    DisplayDataVertically(
        title = title,
        data = data
    )
}
