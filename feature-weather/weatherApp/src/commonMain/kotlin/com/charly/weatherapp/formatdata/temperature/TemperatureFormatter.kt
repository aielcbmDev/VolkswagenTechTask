package com.charly.weatherapp.formatdata.temperature

import com.charly.weatherapp.model.WeatherUnits
import org.jetbrains.compose.resources.getString
import volkswagentechtask.feature_weather.weatherapp.generated.resources.Res
import volkswagentechtask.feature_weather.weatherapp.generated.resources.imperial_temperature_units
import volkswagentechtask.feature_weather.weatherapp.generated.resources.metric_temperature_units
import volkswagentechtask.feature_weather.weatherapp.generated.resources.standard_temperature_units

class TemperatureFormatter(
    private val weatherUnits: WeatherUnits
) {
    suspend fun formatTemperature(temperature: String?): String? {
        if (temperature.isNullOrEmpty()) return null
        return when (weatherUnits) {
            WeatherUnits.STANDARD -> "$temperature ${getString(Res.string.standard_temperature_units)}"
            WeatherUnits.METRIC -> "$temperature ${getString(Res.string.metric_temperature_units)}"
            WeatherUnits.IMPERIAL -> "$temperature ${getString(Res.string.imperial_temperature_units)}"
        }
    }
}
