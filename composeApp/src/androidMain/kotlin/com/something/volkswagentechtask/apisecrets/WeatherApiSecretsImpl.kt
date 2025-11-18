package com.something.volkswagentechtask.apisecrets

import com.something.volkswagentechtask.BuildConfig

class WeatherApiSecretsImpl : WeatherApiSecrets {

    override fun getWeatherApiKey(): String {
        return BuildConfig.WEATHER_API_KEY
    }
}
