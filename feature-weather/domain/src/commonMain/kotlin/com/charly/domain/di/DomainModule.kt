package com.charly.domain.di

import com.charly.domain.usecases.GetDailyWeatherForecastByIdUseCase
import com.charly.domain.usecases.GetDailyWeatherForecastListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetDailyWeatherForecastListUseCase> {
        GetDailyWeatherForecastListUseCase(
            getDailyWeatherForecastListRepository = get()
        )
    }
    factory<GetDailyWeatherForecastByIdUseCase> {
        GetDailyWeatherForecastByIdUseCase(
            getDailyWeatherForecastByIdRepository = get()
        )
    }
}
