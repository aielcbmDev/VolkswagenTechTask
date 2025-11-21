package com.charly.weatherapp.mappers

import com.charly.domain.model.DailyForecast
import com.charly.weatherapp.formatdata.datetime.DateFormatter
import com.charly.weatherapp.model.DailyForecastMainModel

internal fun DailyForecast.mapToDailyForecastMainModel(
    dateFormatter: DateFormatter,
    noDataAvailable: String
): DailyForecastMainModel {
    return DailyForecastMainModel(
        id = id,
        dt = dateFormatter.formatEpochSecondsToDateString(dt) ?: noDataAvailable,
        summary = summary ?: noDataAvailable
    )
}

internal fun List<DailyForecast>.mapToDailyForecastMainModelList(
    dateFormatter: DateFormatter,
    noDataAvailable: String
): List<DailyForecastMainModel> {
    return map { it.mapToDailyForecastMainModel(dateFormatter, noDataAvailable) }
}
