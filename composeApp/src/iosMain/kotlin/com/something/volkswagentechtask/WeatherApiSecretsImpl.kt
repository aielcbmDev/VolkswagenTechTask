package com.something.volkswagentechtask

import platform.Foundation.NSBundle

private const val WEATHER_API_KEY = "WEATHER_API_KEY"

class WeatherApiSecretsImpl : WeatherApiSecrets {
    override fun getWeatherApiKey(): String {
        return NSBundle.mainBundle.objectForInfoDictionaryKey(WEATHER_API_KEY) as? String ?: "DEFAULT_API_KEY"
    }
}
