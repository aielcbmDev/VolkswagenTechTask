package com.charly.weatherapp.mappers

import com.charly.domain.model.DailyForecast
import com.charly.weatherapp.formatdata.datetime.DateFormatter
import com.charly.weatherapp.formatdata.datetime.TimeFormatter
import com.charly.weatherapp.formatdata.speed.SpeedFormatter
import com.charly.weatherapp.formatdata.temperature.TemperatureFormatter
import com.charly.weatherapp.model.DailyForecastModel

internal suspend fun DailyForecast.mapToDailyForecastModel(
    dateFormatter: DateFormatter,
    timeFormatter: TimeFormatter,
    speedFormatter: SpeedFormatter,
    temperatureFormatter: TemperatureFormatter,
    noDataAvailable: String
): DailyForecastModel {
    return DailyForecastModel(
        id = id,
        dt = dateFormatter.formatEpochSecondsToDateString(dt) ?: noDataAvailable,
        sunrise = timeFormatter.formatEpochSecondsToTimeString(sunrise) ?: noDataAvailable,
        sunset = timeFormatter.formatEpochSecondsToTimeString(sunset) ?: noDataAvailable,
        summary = summary ?: noDataAvailable,
        minTemp = temperatureFormatter.formatTemperature(minTemp) ?: noDataAvailable,
        maxTemp = temperatureFormatter.formatTemperature(maxTemp) ?: noDataAvailable
    )
}

internal suspend fun List<DailyForecast>.mapToDailyForecastModelList(
    dateFormatter: DateFormatter,
    timeFormatter: TimeFormatter,
    speedFormatter: SpeedFormatter,
    temperatureFormatter: TemperatureFormatter,
    noDataAvailable: String
): List<DailyForecastModel> {
    return map {
        it.mapToDailyForecastModel(
            dateFormatter = dateFormatter,
            timeFormatter = timeFormatter,
            speedFormatter = speedFormatter,
            temperatureFormatter = temperatureFormatter,
            noDataAvailable = noDataAvailable
        )
    }
}
