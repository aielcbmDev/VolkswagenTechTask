package com.charly.database.datasources

import com.charly.database.model.DailyForecastDao
import com.charly.database.model.DailyForecastEntity
import kotlinx.coroutines.flow.Flow

class WeatherDatabaseDataSource(
    private val dailyForecastDao: DailyForecastDao
) {

    fun getDailyWeatherForecastList(): Flow<List<DailyForecastEntity>> {
        return dailyForecastDao.getDailyWeatherForecastList()
    }

    fun getDailyWeatherForecastById(id: Long): DailyForecastEntity {
        return dailyForecastDao.getDailyWeatherForecastById(id)
    }

    fun insertDailyWeatherForecastList(dailyForecastEntityList: List<DailyForecastEntity>) {
        dailyForecastDao.insertOrReplaceListOfDailyWeatherForecast(dailyForecastEntityList)
    }

    fun deleteDailyWeatherForecastTable() {
        dailyForecastDao.deleteDailyWeatherForecastTable()
    }
}
