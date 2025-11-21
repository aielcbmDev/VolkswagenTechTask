package com.charly.weatherapp.model

import androidx.compose.runtime.Immutable

@Immutable
data class DailyForecastMainModel(
    val id: Long = 0,
    val dt: String,
    val summary: String
)
