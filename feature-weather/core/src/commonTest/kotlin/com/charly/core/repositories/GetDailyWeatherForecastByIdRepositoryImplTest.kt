package com.charly.core.repositories

import com.charly.database.datasources.WeatherDatabaseDataSource
import com.charly.database.model.DailyForecastEntity
import com.charly.domain.model.DailyForecast
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import dev.mokkery.verify.VerifyMode
import dev.mokkery.verifySuspend
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

private const val DAILY_FORECAST_ENTITY =
    "{\"id\":16,\"dt\":1764432000,\"sunrise\":1764417544,\"sunset\":1764451812,\"summary\":\"The day will start with clear sky through the late morning hours, transitioning to partly cloudy\",\"minTemp\":\"1\",\"maxTemp\":\"6.7\",\"windSpeed\":\"6.59\",\"windDeg\":\"279\",\"windGust\":\"12.42\"}"

class GetDailyWeatherForecastByIdRepositoryImplTest {

    @Test
    fun `Verify that a daily forecast is fetched from the database by id successfully`() = runTest {
        // GIVEN
        val id = 16L
        val dailyForecastEntity = Json.decodeFromString<DailyForecastEntity>(DAILY_FORECAST_ENTITY)
        val weatherDatabaseDataSource = mock<WeatherDatabaseDataSource> {
            everySuspend {
                getDailyWeatherForecastById(id)
            } returns dailyForecastEntity
        }
        val getDailyWeatherForecastByIdRepository =
            GetDailyWeatherForecastByIdRepositoryImpl(weatherDatabaseDataSource)

        // WHEN
        val result = getDailyWeatherForecastByIdRepository.execute(id)

        // THEN
        assertIs<DailyForecast>(result)
        assertEquals(dailyForecastEntity.id, result.id)
        assertEquals(dailyForecastEntity.dt, result.dt)
        assertEquals(dailyForecastEntity.sunrise, result.sunrise)
        assertEquals(dailyForecastEntity.sunset, result.sunset)
        assertEquals(dailyForecastEntity.summary, result.summary)
        assertEquals(dailyForecastEntity.minTemp, result.minTemp)
        assertEquals(dailyForecastEntity.maxTemp, result.maxTemp)
        assertEquals(dailyForecastEntity.windSpeed, result.windSpeed)
        assertEquals(dailyForecastEntity.windDeg, result.windDeg)
        assertEquals(dailyForecastEntity.windGust, result.windGust)
        verifySuspend(mode = VerifyMode.exhaustiveOrder) {
            weatherDatabaseDataSource.getDailyWeatherForecastById(id)
        }
    }
}
