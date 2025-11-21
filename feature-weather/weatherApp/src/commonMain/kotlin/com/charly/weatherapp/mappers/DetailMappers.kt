package com.charly.weatherapp.mappers

import com.charly.domain.model.DailyForecast
import com.charly.weatherapp.formatdata.datetime.DateFormatter
import com.charly.weatherapp.formatdata.datetime.TimeFormatter
import com.charly.weatherapp.formatdata.degrees.DegreesFormatter
import com.charly.weatherapp.formatdata.speed.SpeedFormatter
import com.charly.weatherapp.formatdata.temperature.TemperatureFormatter
import com.charly.weatherapp.model.DailyForecastDetailModel

internal suspend fun DailyForecast.mapToDailyForecastDetailModel(
    dateFormatter: DateFormatter,
    timeFormatter: TimeFormatter,
    speedFormatter: SpeedFormatter,
    temperatureFormatter: TemperatureFormatter,
    degreesFormatter: DegreesFormatter,
    noDataAvailable: String
): DailyForecastDetailModel {
    return DailyForecastDetailModel(
        id = id,
        dt = dateFormatter.formatEpochSecondsToDateString(dt) ?: noDataAvailable,
        sunrise = timeFormatter.formatEpochSecondsToTimeString(sunrise) ?: noDataAvailable,
        sunset = timeFormatter.formatEpochSecondsToTimeString(sunset) ?: noDataAvailable,
        summary = summary ?: noDataAvailable,
        minTemp = temperatureFormatter.formatTemperature(minTemp) ?: noDataAvailable,
        maxTemp = temperatureFormatter.formatTemperature(maxTemp) ?: noDataAvailable,
        windSpeed = speedFormatter.formatSpeed(windSpeed) ?: noDataAvailable,
        windDeg = degreesFormatter.formatDegrees(windDeg) ?: noDataAvailable,
        windGust = speedFormatter.formatSpeed(windGust) ?: noDataAvailable
    )
}
