package com.charly.domain.usecases

import com.charly.domain.OpenClassForMocking
import com.charly.domain.model.DailyForecast
import com.charly.domain.repositories.GetDailyWeatherForecastByIdRepository

@OpenClassForMocking
class GetDailyWeatherForecastByIdUseCase(
    private val getDailyWeatherForecastByIdRepository: GetDailyWeatherForecastByIdRepository
) {

    suspend fun execute(id: Long): DailyForecast {
        return getDailyWeatherForecastByIdRepository.execute(id)
    }
}
