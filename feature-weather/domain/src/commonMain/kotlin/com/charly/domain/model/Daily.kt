package com.charly.domain.model

data class Daily(
    val dt: Long? = null,
    val sunrise: Long? = null,
    val sunset: Long? = null,
    val summary: String? = null,
    val minTemp: String? = null,
    val maxTemp: String? = null,
    val weatherDescription: String? = null,
    val weatherIcon: String? = null
)
