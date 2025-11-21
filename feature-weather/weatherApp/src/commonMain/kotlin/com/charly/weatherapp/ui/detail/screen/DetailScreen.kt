package com.charly.weatherapp.ui.detail.screen

import androidx.compose.runtime.Composable
import com.charly.weatherapp.ui.common.error.ScreenError
import com.charly.weatherapp.ui.common.loading.ScreenLoading
import com.charly.weatherapp.ui.detail.DetailScreenState
import com.charly.weatherapp.ui.detail.DetailUiState

@Composable
fun DetailScreen(
    detailScreenState: DetailScreenState,
    onRetryButtonClicked: () -> Unit,
    onBackButtonClicked: () -> Unit
) {
    when (val detailUiState = detailScreenState.detailUiState) {
        is DetailUiState.Loading -> ScreenLoading()
        is DetailUiState.Success -> DetailScreenSuccess(
            dailyForecastDetailModel = detailUiState.dailyForecastDetailModel,
            onBackButtonClicked = onBackButtonClicked
        )

        is DetailUiState.Error -> ScreenError(onRetryButtonClicked)
    }
}
