package com.charly.domain.repositories

import com.charly.domain.model.DailyForecast

fun interface GetDailyWeatherForecastByIdRepository {

    suspend fun execute(id: Long): DailyForecast
}
