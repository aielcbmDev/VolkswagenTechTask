package com.charly.weatherapp.ui.detail.model

import androidx.compose.runtime.Immutable

@Immutable
data class DailyForecastDetailModel(
    val id: Long = 0,
    val dt: String,
    val sunrise: String,
    val sunset: String,
    val summary: String,
    val minTemp: String,
    val maxTemp: String,
    val windSpeed: String,
    val windDeg: String,
    val windGust: String
)
