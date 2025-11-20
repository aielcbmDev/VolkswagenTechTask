package com.charly.domain.usecases

import com.charly.domain.model.DailyForecast
import com.charly.domain.repositories.DailyWeatherForecastRepository
import kotlinx.coroutines.flow.Flow

class DailyWeatherForecastUseCase(
    private val dailyWeatherForecastRepository: DailyWeatherForecastRepository
) {

    suspend fun getDailyWeatherForecastList(): Flow<List<DailyForecast>> {
        return dailyWeatherForecastRepository.getDailyWeatherForecastList()
    }
}
