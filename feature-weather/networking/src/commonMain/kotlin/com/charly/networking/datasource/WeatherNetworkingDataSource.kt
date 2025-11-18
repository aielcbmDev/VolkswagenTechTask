package com.charly.networking.datasource

import com.charly.networking.WeatherApiService
import com.charly.networking.model.DailyForecastWeatherData

class WeatherNetworkingDataSource(
    private val weatherApiService: WeatherApiService
) {

    suspend fun execute(
        latitude: String,
        longitude: String
    ): DailyForecastWeatherData {
        return weatherApiService.getDailyForecastWeatherData(latitude, longitude)
    }
}
