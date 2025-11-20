package com.charly.domain.model

data class DailyForecast(
    val id: Long = 0,
    val dt: Long? = null,
    val sunrise: Long? = null,
    val sunset: Long? = null,
    val summary: String? = null,
    val minTemp: String? = null,
    val maxTemp: String? = null
)
