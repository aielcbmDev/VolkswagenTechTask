package com.charly.database.datasources

import com.charly.database.model.DailyDao
import com.charly.database.model.DailyEntity

class WeatherDatabaseDataSource(
    private val dailyDao: DailyDao
) {

    suspend fun getDailyWeather(): List<DailyEntity> {
        return dailyDao.getDailyWeather()
    }

    suspend fun insertDailyWeatherList(dailyEntityList: List<DailyEntity>) {
        dailyDao.insertOrReplaceListOfDailyWeather(dailyEntityList)
    }
}
