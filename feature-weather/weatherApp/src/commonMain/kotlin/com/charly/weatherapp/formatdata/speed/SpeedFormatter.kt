package com.charly.weatherapp.formatdata.speed

import com.charly.weatherapp.model.WeatherUnits
import org.jetbrains.compose.resources.getString
import volkswagentechtask.feature_weather.weatherapp.generated.resources.Res
import volkswagentechtask.feature_weather.weatherapp.generated.resources.imperial_speed_units
import volkswagentechtask.feature_weather.weatherapp.generated.resources.metric_speed_units
import volkswagentechtask.feature_weather.weatherapp.generated.resources.standard_speed_units

class SpeedFormatter(
    private val weatherUnits: WeatherUnits
) {

    suspend fun formatSpeed(speed: String?): String? {
        if (speed.isNullOrEmpty()) return null
        return when (weatherUnits) {
            WeatherUnits.STANDARD -> "$speed ${getString(Res.string.standard_speed_units)}"
            WeatherUnits.METRIC -> "$speed ${getString(Res.string.metric_speed_units)}"
            WeatherUnits.IMPERIAL -> "$speed ${getString(Res.string.imperial_speed_units)}"
        }
    }
}
