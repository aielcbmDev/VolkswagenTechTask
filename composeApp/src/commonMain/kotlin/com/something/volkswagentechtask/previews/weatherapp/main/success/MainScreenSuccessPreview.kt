package com.something.volkswagentechtask.previews.weatherapp.main.success

import androidx.compose.runtime.Composable
import com.charly.weatherapp.ui.main.model.DailyForecastMainModel
import com.charly.weatherapp.ui.main.screen.MainScreenSuccess
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter

@Preview
@Composable
fun MainScreenSuccessPreview(
    @PreviewParameter(DailyForecastMainModelListParameterProvider::class) dailyForecastMainModelList: List<DailyForecastMainModel>,
    onDailyForecastModelClick: (Long) -> Unit = {}
) {
    MainScreenSuccess(
        dailyForecastMainModelList = dailyForecastMainModelList,
        onDailyForecastModelClick = onDailyForecastModelClick
    )
}
