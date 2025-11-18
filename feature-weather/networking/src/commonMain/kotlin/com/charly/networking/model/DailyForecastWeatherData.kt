package com.charly.networking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyForecastWeatherData(

    @SerialName("lat")
    val lat: Double? = null,
    @SerialName("lon")
    val lon: Double? = null,
    @SerialName("timezone")
    val timezone: String? = null,
    @SerialName("timezone_offset")
    val timezoneOffset: Int? = null,
    @SerialName("daily")
    val daily: List<DailyData> = emptyList()
)
