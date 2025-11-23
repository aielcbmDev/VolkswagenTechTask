package com.charly.core.mappers.database

import com.charly.database.model.DailyForecastEntity
import com.charly.domain.model.DailyForecast
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

private const val DAILY_FORECAST_ENTITY =
    "{\"id\":16,\"dt\":1764432000,\"sunrise\":1764417544,\"sunset\":1764451812,\"summary\":\"The day will start with clear sky through the late morning hours, transitioning to partly cloudy\",\"minTemp\":\"1\",\"maxTemp\":\"6.7\",\"windSpeed\":\"6.59\",\"windDeg\":\"279\",\"windGust\":\"12.42\"}"
private const val DAILY_WEATHER_FORECAST_LIST =
    "[{\"id\":1,\"dt\":1763827200,\"sunrise\":1763812283,\"sunset\":1763847206,\"summary\":\"Expect a day of partly cloudy with rain\",\"minTemp\":\"5.64\",\"maxTemp\":\"10.6\",\"windSpeed\":\"5.44\",\"windDeg\":\"338\",\"windGust\":\"8.32\"},{\"id\":2,\"dt\":1763913600,\"sunrise\":1763898751,\"sunset\":1763933572,\"summary\":\"Expect a day of partly cloudy with clear spells\",\"minTemp\":\"4.08\",\"maxTemp\":\"9.62\",\"windSpeed\":\"6.22\",\"windDeg\":\"294\",\"windGust\":\"12.17\"},{\"id\":3,\"dt\":1764000000,\"sunrise\":1763985218,\"sunset\":1764019940,\"summary\":\"Expect a day of partly cloudy with clear spells\",\"minTemp\":\"5.36\",\"maxTemp\":\"9.79\",\"windSpeed\":\"6.75\",\"windDeg\":\"325\",\"windGust\":\"12.25\"},{\"id\":4,\"dt\":1764086400,\"sunrise\":1764071685,\"sunset\":1764106310,\"summary\":\"You can expect partly cloudy in the morning, with rain in the afternoon\",\"minTemp\":\"6.12\",\"maxTemp\":\"10.14\",\"windSpeed\":\"3.46\",\"windDeg\":\"168\",\"windGust\":\"10.93\"},{\"id\":5,\"dt\":1764172800,\"sunrise\":1764158151,\"sunset\":1764192682,\"summary\":\"You can expect partly cloudy in the morning, with rain in the afternoon\",\"minTemp\":\"10.07\",\"maxTemp\":\"12.87\",\"windSpeed\":\"2.3\",\"windDeg\":\"241\",\"windGust\":\"7.04\"},{\"id\":6,\"dt\":1764259200,\"sunrise\":1764244616,\"sunset\":1764279057,\"summary\":\"Expect a day of partly cloudy with rain\",\"minTemp\":\"3.29\",\"maxTemp\":\"13.01\",\"windSpeed\":\"8.51\",\"windDeg\":\"271\",\"windGust\":\"12.81\"},{\"id\":7,\"dt\":1764345600,\"sunrise\":1764331080,\"sunset\":1764365433,\"summary\":\"Expect a day of partly cloudy with clear spells\",\"minTemp\":\"1.01\",\"maxTemp\":\"4.8\",\"windSpeed\":\"9\",\"windDeg\":\"274\",\"windGust\":\"14.63\"},{\"id\":8,\"dt\":1764432000,\"sunrise\":1764417544,\"sunset\":1764451812,\"summary\":\"Expect a day of partly cloudy with clear spells\",\"minTemp\":\"1.15\",\"maxTemp\":\"5.62\",\"windSpeed\":\"7.54\",\"windDeg\":\"305\",\"windGust\":\"14.61\"}]"

class MappersTest {

    @Test
    fun `Verify that a DailyForecastEntity is mapped to a DailyForecast`() {
        // GIVEN
        val dailyForecastEntity = Json.decodeFromString<DailyForecastEntity>(DAILY_FORECAST_ENTITY)

        // WHEN
        val result = dailyForecastEntity.mapToDailyForecast()

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
    }

    @Test
    fun `Verify that a list of DailyForecastEntity is mapped to a list of DailyForecast`() {
        // GIVEN
        val dailyForecastEntityList =
            Json.decodeFromString<List<DailyForecastEntity>>(DAILY_WEATHER_FORECAST_LIST)

        // WHEN
        val result = dailyForecastEntityList.mapToDailyForecastList()

        // THEN
        assertIs<List<DailyForecast>>(result)
        assertEquals(dailyForecastEntityList.size, result.size)
        val dailyForecastEntity0 = dailyForecastEntityList[0]
        val dailyForecast0 = result[0]
        assertEquals(dailyForecastEntity0.id, dailyForecast0.id)
        assertEquals(dailyForecastEntity0.dt, dailyForecast0.dt)
        assertEquals(dailyForecastEntity0.sunrise, dailyForecast0.sunrise)
        assertEquals(dailyForecastEntity0.sunset, dailyForecast0.sunset)
        assertEquals(dailyForecastEntity0.summary, dailyForecast0.summary)
        assertEquals(dailyForecastEntity0.minTemp, dailyForecast0.minTemp)
        assertEquals(dailyForecastEntity0.maxTemp, dailyForecast0.maxTemp)
        assertEquals(dailyForecastEntity0.windSpeed, dailyForecast0.windSpeed)
        assertEquals(dailyForecastEntity0.windDeg, dailyForecast0.windDeg)
        assertEquals(dailyForecastEntity0.windGust, dailyForecast0.windGust)

        val dailyForecastEntity1 = dailyForecastEntityList[1]
        val dailyForecast1 = result[1]
        assertEquals(dailyForecastEntity1.id, dailyForecast1.id)
        assertEquals(dailyForecastEntity1.dt, dailyForecast1.dt)
        assertEquals(dailyForecastEntity1.sunrise, dailyForecast1.sunrise)
        assertEquals(dailyForecastEntity1.sunset, dailyForecast1.sunset)
        assertEquals(dailyForecastEntity1.summary, dailyForecast1.summary)
        assertEquals(dailyForecastEntity1.minTemp, dailyForecast1.minTemp)
        assertEquals(dailyForecastEntity1.maxTemp, dailyForecast1.maxTemp)
        assertEquals(dailyForecastEntity1.windSpeed, dailyForecast1.windSpeed)
        assertEquals(dailyForecastEntity1.windDeg, dailyForecast1.windDeg)
        assertEquals(dailyForecastEntity1.windGust, dailyForecast1.windGust)

        val dailyForecastEntity2 = dailyForecastEntityList[2]
        val dailyForecast2 = result[2]
        assertEquals(dailyForecastEntity2.id, dailyForecast2.id)
        assertEquals(dailyForecastEntity2.dt, dailyForecast2.dt)
        assertEquals(dailyForecastEntity2.sunrise, dailyForecast2.sunrise)
        assertEquals(dailyForecastEntity2.sunset, dailyForecast2.sunset)
        assertEquals(dailyForecastEntity2.summary, dailyForecast2.summary)
        assertEquals(dailyForecastEntity2.minTemp, dailyForecast2.minTemp)
        assertEquals(dailyForecastEntity2.maxTemp, dailyForecast2.maxTemp)
        assertEquals(dailyForecastEntity2.windSpeed, dailyForecast2.windSpeed)
        assertEquals(dailyForecastEntity2.windDeg, dailyForecast2.windDeg)
        assertEquals(dailyForecastEntity2.windGust, dailyForecast2.windGust)

        val dailyForecastEntity3 = dailyForecastEntityList[3]
        val dailyForecast3 = result[3]
        assertEquals(dailyForecastEntity3.id, dailyForecast3.id)
        assertEquals(dailyForecastEntity3.dt, dailyForecast3.dt)
        assertEquals(dailyForecastEntity3.sunrise, dailyForecast3.sunrise)
        assertEquals(dailyForecastEntity3.sunset, dailyForecast3.sunset)
        assertEquals(dailyForecastEntity3.summary, dailyForecast3.summary)
        assertEquals(dailyForecastEntity3.minTemp, dailyForecast3.minTemp)
        assertEquals(dailyForecastEntity3.maxTemp, dailyForecast3.maxTemp)
        assertEquals(dailyForecastEntity3.windSpeed, dailyForecast3.windSpeed)
        assertEquals(dailyForecastEntity3.windDeg, dailyForecast3.windDeg)
        assertEquals(dailyForecastEntity3.windGust, dailyForecast3.windGust)

        val dailyForecastEntity4 = dailyForecastEntityList[4]
        val dailyForecast4 = result[4]
        assertEquals(dailyForecastEntity4.id, dailyForecast4.id)
        assertEquals(dailyForecastEntity4.dt, dailyForecast4.dt)
        assertEquals(dailyForecastEntity4.sunrise, dailyForecast4.sunrise)
        assertEquals(dailyForecastEntity4.sunset, dailyForecast4.sunset)
        assertEquals(dailyForecastEntity4.summary, dailyForecast4.summary)
        assertEquals(dailyForecastEntity4.minTemp, dailyForecast4.minTemp)
        assertEquals(dailyForecastEntity4.maxTemp, dailyForecast4.maxTemp)
        assertEquals(dailyForecastEntity4.windSpeed, dailyForecast4.windSpeed)
        assertEquals(dailyForecastEntity4.windDeg, dailyForecast4.windDeg)
        assertEquals(dailyForecastEntity4.windGust, dailyForecast4.windGust)

        val dailyForecastEntity5 = dailyForecastEntityList[5]
        val dailyForecast5 = result[5]
        assertEquals(dailyForecastEntity5.id, dailyForecast5.id)
        assertEquals(dailyForecastEntity5.dt, dailyForecast5.dt)
        assertEquals(dailyForecastEntity5.sunrise, dailyForecast5.sunrise)
        assertEquals(dailyForecastEntity5.sunset, dailyForecast5.sunset)
        assertEquals(dailyForecastEntity5.summary, dailyForecast5.summary)
        assertEquals(dailyForecastEntity5.minTemp, dailyForecast5.minTemp)
        assertEquals(dailyForecastEntity5.maxTemp, dailyForecast5.maxTemp)
        assertEquals(dailyForecastEntity5.windSpeed, dailyForecast5.windSpeed)
        assertEquals(dailyForecastEntity5.windDeg, dailyForecast5.windDeg)
        assertEquals(dailyForecastEntity5.windGust, dailyForecast5.windGust)

        val dailyForecastEntity6 = dailyForecastEntityList[6]
        val dailyForecast6 = result[6]
        assertEquals(dailyForecastEntity6.id, dailyForecast6.id)
        assertEquals(dailyForecastEntity6.dt, dailyForecast6.dt)
        assertEquals(dailyForecastEntity6.sunrise, dailyForecast6.sunrise)
        assertEquals(dailyForecastEntity6.sunset, dailyForecast6.sunset)
        assertEquals(dailyForecastEntity6.summary, dailyForecast6.summary)
        assertEquals(dailyForecastEntity6.minTemp, dailyForecast6.minTemp)
        assertEquals(dailyForecastEntity6.maxTemp, dailyForecast6.maxTemp)
        assertEquals(dailyForecastEntity6.windSpeed, dailyForecast6.windSpeed)
        assertEquals(dailyForecastEntity6.windDeg, dailyForecast6.windDeg)
        assertEquals(dailyForecastEntity6.windGust, dailyForecast6.windGust)

        val dailyForecastEntity7 = dailyForecastEntityList[7]
        val dailyForecast7 = result[7]
        assertEquals(dailyForecastEntity7.id, dailyForecast7.id)
        assertEquals(dailyForecastEntity7.dt, dailyForecast7.dt)
        assertEquals(dailyForecastEntity7.sunrise, dailyForecast7.sunrise)
        assertEquals(dailyForecastEntity7.sunset, dailyForecast7.sunset)
        assertEquals(dailyForecastEntity7.summary, dailyForecast7.summary)
        assertEquals(dailyForecastEntity7.minTemp, dailyForecast7.minTemp)
        assertEquals(dailyForecastEntity7.maxTemp, dailyForecast7.maxTemp)
        assertEquals(dailyForecastEntity7.windSpeed, dailyForecast7.windSpeed)
        assertEquals(dailyForecastEntity7.windDeg, dailyForecast7.windDeg)
        assertEquals(dailyForecastEntity7.windGust, dailyForecast7.windGust)
    }
}
