package com.charly.domain.repositories

import com.charly.domain.model.DailyForecast
import kotlinx.coroutines.flow.Flow

fun interface DailyWeatherForecastRepository {

    suspend fun getDailyWeatherForecastList(): Flow<List<DailyForecast>>
}
