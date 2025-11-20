package com.charly.core.repositories

import com.charly.core.mappers.database.mapToDailyForecast
import com.charly.database.datasources.WeatherDatabaseDataSource
import com.charly.domain.model.DailyForecast
import com.charly.domain.repositories.GetDailyWeatherForecastByIdRepository

class GetDailyWeatherForecastByIdRepositoryImpl(
    private val weatherDatabaseDataSource: WeatherDatabaseDataSource
) : GetDailyWeatherForecastByIdRepository {

    override suspend fun execute(id: Long): DailyForecast {
        return weatherDatabaseDataSource.getDailyWeatherForecastById(id).mapToDailyForecast()
    }
}
