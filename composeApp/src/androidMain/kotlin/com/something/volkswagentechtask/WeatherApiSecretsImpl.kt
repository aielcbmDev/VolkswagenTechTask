package com.something.volkswagentechtask

class WeatherApiSecretsImpl : WeatherApiSecrets {

    override fun getWeatherApiKey(): String {
        return BuildConfig.WEATHER_API_KEY
    }
}
