package com.charly.core.mappers.database

import com.charly.database.model.DailyForecastEntity
import com.charly.domain.model.DailyForecast

internal fun DailyForecastEntity.mapToDailyForecast(): DailyForecast {
    return DailyForecast(
        id = id,
        dt = dt,
        sunrise = sunrise,
        sunset = sunset,
        summary = summary,
        minTemp = minTemp,
        maxTemp = maxTemp,
        windSpeed = windSpeed,
        windDeg = windDeg,
        windGust = windGust
    )
}

internal fun List<DailyForecastEntity>.mapToDailyForecastList(): List<DailyForecast> {
    return map { it.mapToDailyForecast() }
}
