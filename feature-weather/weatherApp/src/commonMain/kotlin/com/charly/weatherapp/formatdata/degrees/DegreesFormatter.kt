package com.charly.weatherapp.formatdata.degrees

import org.jetbrains.compose.resources.getString
import volkswagentechtask.feature_weather.weatherapp.generated.resources.Res
import volkswagentechtask.feature_weather.weatherapp.generated.resources.degrees_units
import volkswagentechtask.feature_weather.weatherapp.generated.resources.display_data_with_units_text

class DegreesFormatter {

    suspend fun formatDegrees(degrees: String?): String? {
        if (degrees.isNullOrEmpty()) return null
        val units = getString(Res.string.degrees_units)
        return getString(Res.string.display_data_with_units_text, degrees, units)
    }
}
