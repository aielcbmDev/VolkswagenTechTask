package com.charly.domain.usecases

import com.charly.domain.model.DailyForecast
import com.charly.domain.repositories.GetDailyWeatherForecastListRepository
import kotlinx.coroutines.flow.Flow

class GetDailyWeatherForecastListUseCase(
    private val getDailyWeatherForecastListRepository: GetDailyWeatherForecastListRepository
) {

    suspend fun execute(): Flow<List<DailyForecast>> {
        return getDailyWeatherForecastListRepository.execute()
    }
}
