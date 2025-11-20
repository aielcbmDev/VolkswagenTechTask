package com.charly.core.mappers.database

import com.charly.database.model.DailyForecastEntity
import com.charly.domain.model.DailyForecast

internal fun DailyForecastEntity.mapToDaily(): DailyForecast {
    return DailyForecast(
        id = id,
        dt = dt,
        sunrise = sunrise,
        sunset = sunset,
        summary = summary,
        minTemp = minTemp,
        maxTemp = maxTemp
    )
}

internal fun List<DailyForecastEntity>.mapToDailyList(): List<DailyForecast> {
    return map { it.mapToDaily() }
}
