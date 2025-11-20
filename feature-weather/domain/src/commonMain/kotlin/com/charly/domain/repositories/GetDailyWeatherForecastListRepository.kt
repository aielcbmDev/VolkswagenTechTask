package com.charly.domain.repositories

import com.charly.domain.model.DailyForecast
import kotlinx.coroutines.flow.Flow

fun interface GetDailyWeatherForecastListRepository {

    suspend fun execute(): Flow<List<DailyForecast>>
}
