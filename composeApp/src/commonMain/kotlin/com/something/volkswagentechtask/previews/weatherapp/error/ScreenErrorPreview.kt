package com.something.volkswagentechtask.previews.weatherapp.error

import androidx.compose.runtime.Composable
import com.charly.weatherapp.ui.common.error.ScreenError
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ScreenErrorPreview(
    onRetryButtonClicked: () -> Unit = {}
) {
    ScreenError(onRetryButtonClicked)
}
