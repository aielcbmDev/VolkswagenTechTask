package com.charly.database.datasources

import com.charly.database.model.DailyDao
import com.charly.database.model.DailyForecastEntity
import kotlinx.coroutines.flow.Flow

class WeatherDatabaseDataSource(
    private val dailyDao: DailyDao
) {

    fun getDailyWeatherForecastList(): Flow<List<DailyForecastEntity>> {
        return dailyDao.getDailyWeatherForecastList()
    }

    suspend fun insertDailyWeatherForecastList(dailyForecastEntityList: List<DailyForecastEntity>) {
        dailyDao.insertOrReplaceListOfDailyWeatherForecast(dailyForecastEntityList)
    }

    suspend fun deleteDailyWeatherForecastTable() {
        dailyDao.deleteDailyWeatherForecastTable()
    }
}
