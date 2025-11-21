package com.charly.weatherapp.ui.mainscreen

import androidx.compose.runtime.Composable
import com.charly.weatherapp.ui.common.error.ScreenError
import com.charly.weatherapp.ui.common.loading.ScreenLoading
import com.charly.weatherapp.ui.mainscreen.success.MainScreenSuccess

@Composable
fun MainScreen(
    mainScreenState: MainScreenState,
    onDailyForecastModelClick: (Long) -> Unit,
    onRetryButtonClicked: () -> Unit
) {
    when (val uiState = mainScreenState.mainUiState) {
        is MainUiState.Loading -> ScreenLoading()
        is MainUiState.Success -> MainScreenSuccess(
            dailyForecastMainModelList = uiState.dailyForecastMainModelList,
            onDailyForecastModelClick = onDailyForecastModelClick
        )

        is MainUiState.Error -> ScreenError(onRetryButtonClicked)
    }
}
