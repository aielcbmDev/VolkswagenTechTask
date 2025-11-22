package com.something.volkswagentechtask.previews.weatherapp.detail.success

import androidx.compose.runtime.Composable
import com.charly.weatherapp.ui.detail.model.DailyForecastDetailModel
import com.charly.weatherapp.ui.detail.screen.DetailScreenSuccess
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter

@Preview
@Composable
fun DetailScreenSuccessPreview(
    @PreviewParameter(DetailScreenSuccessParameterProvider::class) dailyForecastDetailModel: DailyForecastDetailModel,
    onBackButtonClicked: () -> Unit = {}
) {
    DetailScreenSuccess(
        dailyForecastDetailModel = dailyForecastDetailModel,
        onBackButtonClicked = onBackButtonClicked
    )
}
