package com.charly.core.networking.mappers

import com.charly.domain.model.Daily
import com.charly.networking.model.DailyData
import com.charly.networking.model.DailyForecastWeatherData

private fun DailyData.mapToDaily(): Daily {
    return Daily(
        dt = dt,
        sunrise = sunrise,
        sunset = sunset,
        summary = summary,
        minTemp = temp?.min,
        maxTemp = temp?.max
    )
}

/**
 * This function is responsible for mapping the incoming DailyForecastWeatherData DTO (Data Transfer
 * Object) from the network layer to a list of Daily objects for the domain layer.
 *
 * This mapping stage determines which data fields are persisted and used within the app, and which
 * are discarded. For the purpose of this task, only a few key parameters are mapped to maintain
 * simplicity. This has the direct benefit of simplifying the database implementation as well. In a
 * production environment, this mapping would be expanded to include more fields, leading to a more
 * comprehensive data model and, consequently, a more complex database schema.
 */
internal fun DailyForecastWeatherData.mapToDaily(): List<Daily> {
    return this.daily.map { it.mapToDaily() }
}
