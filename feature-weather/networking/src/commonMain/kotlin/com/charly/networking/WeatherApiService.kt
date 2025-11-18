package com.charly.networking

import com.charly.networking.model.DailyForecastWeatherData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class WeatherApiService(
    private val weatherApiKey: String,
    private val httpClient: HttpClient
) {

    suspend fun getDailyForecastWeatherData(
        latitude: String,
        longitude: String
    ): DailyForecastWeatherData {
        val url = generateUrl(latitude, longitude, weatherApiKey)
        return httpClient.get(url).body<DailyForecastWeatherData>()
    }

    private companion object Companion {

        fun generateUrl(
            latitude: String,
            longitude: String,
            weatherApiKey: String
        ): String {
            return "https://api.openweathermap.org/data/3.0/onecall?lat=$latitude&lon=$longitude&exclude=current,minutely,hourly,alerts&appid=$weatherApiKey"
        }
    }
}
