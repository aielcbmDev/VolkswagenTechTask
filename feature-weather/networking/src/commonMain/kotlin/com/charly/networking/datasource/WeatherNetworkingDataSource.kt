package com.charly.networking.datasource

import com.charly.networking.OpenClassForMocking
import com.charly.networking.WeatherApiService
import com.charly.networking.model.DailyForecastWeatherData

@OpenClassForMocking
class WeatherNetworkingDataSource(
    private val weatherApiService: WeatherApiService
) {

    suspend fun getDailyWeatherForecastData(): DailyForecastWeatherData {
        return weatherApiService.getDailyWeatherForecastData()
    }
}
