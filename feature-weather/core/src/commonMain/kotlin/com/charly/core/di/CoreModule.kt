package com.charly.core.di

import com.charly.core.cache.TimerCache
import com.charly.core.repositories.GetDailyWeatherForecastListRepositoryImpl
import com.charly.database.di.databaseModule
import com.charly.datastore.di.datastoreModule
import com.charly.domain.repositories.GetDailyWeatherForecastListRepository
import com.charly.networking.di.networkingModule
import org.koin.dsl.module
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
val coreModule = module {
    includes(databaseModule)
    includes(datastoreModule)
    includes(networkingModule)

    factory<Clock> { Clock.System }
    factory<TimerCache> {
        TimerCache(
            clock = get(),
            datastoreDataSource = get()
        )
    }
    factory<GetDailyWeatherForecastListRepository> {
        GetDailyWeatherForecastListRepositoryImpl(
            timerCache = get(),
            weatherDatabaseDataSource = get(),
            weatherNetworkDataSource = get()
        )
    }
}
