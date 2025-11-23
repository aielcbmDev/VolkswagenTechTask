package com.charly.core.mappers.networking

import com.charly.database.model.DailyForecastEntity
import com.charly.networking.model.DailyForecastWeatherData
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

private const val WEATHER_JSON_DATA =
    "{\"lat\":\"40.7128\",\"lon\":\"-74.006\",\"timezone\":\"America/New_York\",\"timezone_offset\":-18000,\"daily\":[{\"dt\":1763827200,\"sunrise\":1763812283,\"sunset\":1763847206,\"moonrise\":1763821260,\"moonset\":1763852160,\"moon_phase\":\"0.07\",\"summary\":\"Expect a day of partly cloudy with rain\",\"temp\":{\"day\":\"9.37\",\"min\":\"5.69\",\"max\":\"10.81\",\"night\":\"5.69\",\"eve\":\"10.34\",\"morn\":\"8.85\"},\"feels_like\":{\"day\":\"7.86\",\"night\":\"3.31\",\"eve\":\"9\",\"morn\":\"7.7\"},\"pressure\":\"1012\",\"humidity\":\"77\",\"dew_point\":\"5.55\",\"wind_speed\":\"5.51\",\"wind_deg\":\"326\",\"wind_gust\":\"8.17\",\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"clouds\":\"99\",\"pop\":\"1\",\"uvi\":\"1.41\"},{\"dt\":1763913600,\"sunrise\":1763898751,\"sunset\":1763933572,\"moonrise\":1763910600,\"moonset\":1763941980,\"moon_phase\":\"0.1\",\"summary\":\"Expect a day of partly cloudy with clear spells\",\"temp\":{\"day\":\"7.23\",\"min\":\"4.22\",\"max\":\"10.19\",\"night\":\"6.79\",\"eve\":\"9.19\",\"morn\":\"4.49\"},\"feels_like\":{\"day\":\"4.72\",\"night\":\"3.47\",\"eve\":\"6.58\",\"morn\":\"4.49\"},\"pressure\":\"1016\",\"humidity\":\"48\",\"dew_point\":\"-3.21\",\"wind_speed\":\"5.98\",\"wind_deg\":\"294\",\"wind_gust\":\"11.24\",\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":\"20\",\"pop\":\"0\",\"uvi\":\"1.51\"},{\"dt\":1764000000,\"sunrise\":1763985218,\"sunset\":1764019940,\"moonrise\":1763999520,\"moonset\":1764032160,\"moon_phase\":\"0.13\",\"summary\":\"Expect a day of partly cloudy with clear spells\",\"temp\":{\"day\":\"7.73\",\"min\":\"5.28\",\"max\":\"9.8\",\"night\":\"7.27\",\"eve\":\"8.96\",\"morn\":\"5.72\"},\"feels_like\":{\"day\":\"4.37\",\"night\":\"7.27\",\"eve\":\"7.54\",\"morn\":\"1.85\"},\"pressure\":\"1023\",\"humidity\":\"47\",\"dew_point\":\"-3.05\",\"wind_speed\":\"6.44\",\"wind_deg\":\"328\",\"wind_gust\":\"12.64\",\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":\"10\",\"pop\":\"0\",\"uvi\":\"1.99\"},{\"dt\":1764086400,\"sunrise\":1764071685,\"sunset\":1764106310,\"moonrise\":1764088020,\"moonset\":1764122520,\"moon_phase\":\"0.17\",\"summary\":\"You can expect partly cloudy in the morning, with rain in the afternoon\",\"temp\":{\"day\":\"9.44\",\"min\":\"6.42\",\"max\":\"10.61\",\"night\":\"10.61\",\"eve\":\"8.59\",\"morn\":\"6.46\"},\"feels_like\":{\"day\":\"7.41\",\"night\":\"10.31\",\"eve\":\"6.39\",\"morn\":\"4.85\"},\"pressure\":\"1024\",\"humidity\":\"54\",\"dew_point\":\"0.56\",\"wind_speed\":\"5.4\",\"wind_deg\":\"152\",\"wind_gust\":\"11.57\",\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"clouds\":\"100\",\"pop\":\"1\",\"uvi\":\"1.14\"},{\"dt\":1764172800,\"sunrise\":1764158151,\"sunset\":1764192682,\"moonrise\":1764176160,\"moonset\":1764212940,\"moon_phase\":\"0.2\",\"summary\":\"Expect a day of partly cloudy with rain\",\"temp\":{\"day\":\"11.87\",\"min\":\"10.85\",\"max\":\"13.48\",\"night\":\"12.82\",\"eve\":\"13.4\",\"morn\":\"10.95\"},\"feels_like\":{\"day\":\"11.57\",\"night\":\"12.77\",\"eve\":\"13.28\",\"morn\":\"10.66\"},\"pressure\":\"1015\",\"humidity\":\"94\",\"dew_point\":\"10.83\",\"wind_speed\":\"2.51\",\"wind_deg\":\"223\",\"wind_gust\":\"10.11\",\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":\"100\",\"pop\":\"1\",\"uvi\":\"1.52\"},{\"dt\":1764259200,\"sunrise\":1764244616,\"sunset\":1764279057,\"moonrise\":1764264060,\"moonset\":1764303420,\"moon_phase\":\"0.23\",\"summary\":\"Expect a day of partly cloudy with rain\",\"temp\":{\"day\":\"5.99\",\"min\":\"2.58\",\"max\":\"13.71\",\"night\":\"2.58\",\"eve\":\"5.91\",\"morn\":\"9.42\"},\"feels_like\":{\"day\":\"1.43\",\"night\":\"-3.19\",\"eve\":\"1.27\",\"morn\":\"5.78\"},\"pressure\":\"1011\",\"humidity\":\"50\",\"dew_point\":\"-3.73\",\"wind_speed\":\"8.71\",\"wind_deg\":\"268\",\"wind_gust\":\"14.36\",\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":\"20\",\"pop\":\"1\",\"uvi\":\"2\"},{\"dt\":1764345600,\"sunrise\":1764331080,\"sunset\":1764365433,\"moonrise\":1764351900,\"moonset\":0,\"moon_phase\":\"0.25\",\"summary\":\"Expect a day of partly cloudy with clear spells\",\"temp\":{\"day\":\"2.56\",\"min\":\"0.97\",\"max\":\"5.28\",\"night\":\"2.58\",\"eve\":\"5.28\",\"morn\":\"1.17\"},\"feels_like\":{\"day\":\"-3.5\",\"night\":\"-2.79\",\"eve\":\"0.39\",\"morn\":\"-5.11\"},\"pressure\":\"1015\",\"humidity\":\"51\",\"dew_point\":\"-6.74\",\"wind_speed\":\"9.6\",\"wind_deg\":\"257\",\"wind_gust\":\"15.7\",\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":\"23\",\"pop\":\"0\",\"uvi\":\"2\"},{\"dt\":1764432000,\"sunrise\":1764417544,\"sunset\":1764451812,\"moonrise\":1764439620,\"moonset\":1764393900,\"moon_phase\":\"0.3\",\"summary\":\"You can expect clear sky in the morning, with partly cloudy in the afternoon\",\"temp\":{\"day\":\"2.83\",\"min\":\"0.83\",\"max\":\"5.87\",\"night\":\"3.8\",\"eve\":\"5.87\",\"morn\":\"1.09\"},\"feels_like\":{\"day\":\"-2.1\",\"night\":\"1.65\",\"eve\":\"2.54\",\"morn\":\"-4.51\"},\"pressure\":\"1028\",\"humidity\":\"47\",\"dew_point\":\"-7.51\",\"wind_speed\":\"7.2\",\"wind_deg\":\"273\",\"wind_gust\":\"13.66\",\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":\"6\",\"pop\":\"0\",\"uvi\":\"2\"}]}"

class NetworkingMappersTest {

    @Test
    fun `Verify that a DailyForecastWeatherData is mapped to a list of DailyForecastEntity`() {
        // GIVEN
        val dailyForecastWeatherData =
            Json.decodeFromString<DailyForecastWeatherData>(WEATHER_JSON_DATA)

        // WHEN
        val result = dailyForecastWeatherData.mapToDailyForecastEntityList()

        // THEN
        assertIs<List<DailyForecastEntity>>(result)
        assertEquals(dailyForecastWeatherData.daily.size, result.size)
        val dailyForecastData0 = dailyForecastWeatherData.daily[0]
        val dailyForecastEntity0 = result[0]
        assertEquals(0, dailyForecastEntity0.id)
        assertEquals(dailyForecastData0.dt, dailyForecastEntity0.dt)
        assertEquals(dailyForecastData0.sunrise, dailyForecastEntity0.sunrise)
        assertEquals(dailyForecastData0.sunset, dailyForecastEntity0.sunset)
        assertEquals(dailyForecastData0.summary, dailyForecastEntity0.summary)
        assertEquals(dailyForecastData0.temp?.min, dailyForecastEntity0.minTemp)
        assertEquals(dailyForecastData0.temp?.max, dailyForecastEntity0.maxTemp)
        assertEquals(dailyForecastData0.windSpeed, dailyForecastEntity0.windSpeed)
        assertEquals(dailyForecastData0.windDeg, dailyForecastEntity0.windDeg)
        assertEquals(dailyForecastData0.windGust, dailyForecastEntity0.windGust)

        val dailyForecastData1 = dailyForecastWeatherData.daily[1]
        val dailyForecastEntity1 = result[1]
        assertEquals(0, dailyForecastEntity1.id)
        assertEquals(dailyForecastData1.dt, dailyForecastEntity1.dt)
        assertEquals(dailyForecastData1.sunrise, dailyForecastEntity1.sunrise)
        assertEquals(dailyForecastData1.sunset, dailyForecastEntity1.sunset)
        assertEquals(dailyForecastData1.summary, dailyForecastEntity1.summary)
        assertEquals(dailyForecastData1.temp?.min, dailyForecastEntity1.minTemp)
        assertEquals(dailyForecastData1.temp?.max, dailyForecastEntity1.maxTemp)
        assertEquals(dailyForecastData1.windSpeed, dailyForecastEntity1.windSpeed)
        assertEquals(dailyForecastData1.windDeg, dailyForecastEntity1.windDeg)
        assertEquals(dailyForecastData1.windGust, dailyForecastEntity1.windGust)

        val dailyForecastData2 = dailyForecastWeatherData.daily[2]
        val dailyForecastEntity2 = result[2]
        assertEquals(0, dailyForecastEntity2.id)
        assertEquals(dailyForecastData2.dt, dailyForecastEntity2.dt)
        assertEquals(dailyForecastData2.sunrise, dailyForecastEntity2.sunrise)
        assertEquals(dailyForecastData2.sunset, dailyForecastEntity2.sunset)
        assertEquals(dailyForecastData2.summary, dailyForecastEntity2.summary)
        assertEquals(dailyForecastData2.temp?.min, dailyForecastEntity2.minTemp)
        assertEquals(dailyForecastData2.temp?.max, dailyForecastEntity2.maxTemp)
        assertEquals(dailyForecastData2.windSpeed, dailyForecastEntity2.windSpeed)
        assertEquals(dailyForecastData2.windDeg, dailyForecastEntity2.windDeg)
        assertEquals(dailyForecastData2.windGust, dailyForecastEntity2.windGust)

        val dailyForecastData3 = dailyForecastWeatherData.daily[3]
        val dailyForecastEntity3 = result[3]
        assertEquals(0, dailyForecastEntity3.id)
        assertEquals(dailyForecastData3.dt, dailyForecastEntity3.dt)
        assertEquals(dailyForecastData3.sunrise, dailyForecastEntity3.sunrise)
        assertEquals(dailyForecastData3.sunset, dailyForecastEntity3.sunset)
        assertEquals(dailyForecastData3.summary, dailyForecastEntity3.summary)
        assertEquals(dailyForecastData3.temp?.min, dailyForecastEntity3.minTemp)
        assertEquals(dailyForecastData3.temp?.max, dailyForecastEntity3.maxTemp)
        assertEquals(dailyForecastData3.windSpeed, dailyForecastEntity3.windSpeed)
        assertEquals(dailyForecastData3.windDeg, dailyForecastEntity3.windDeg)
        assertEquals(dailyForecastData3.windGust, dailyForecastEntity3.windGust)

        val dailyForecastData4 = dailyForecastWeatherData.daily[4]
        val dailyForecastEntity4 = result[4]
        assertEquals(0, dailyForecastEntity4.id)
        assertEquals(dailyForecastData4.dt, dailyForecastEntity4.dt)
        assertEquals(dailyForecastData4.sunrise, dailyForecastEntity4.sunrise)
        assertEquals(dailyForecastData4.sunset, dailyForecastEntity4.sunset)
        assertEquals(dailyForecastData4.summary, dailyForecastEntity4.summary)
        assertEquals(dailyForecastData4.temp?.min, dailyForecastEntity4.minTemp)
        assertEquals(dailyForecastData4.temp?.max, dailyForecastEntity4.maxTemp)
        assertEquals(dailyForecastData4.windSpeed, dailyForecastEntity4.windSpeed)
        assertEquals(dailyForecastData4.windDeg, dailyForecastEntity4.windDeg)
        assertEquals(dailyForecastData4.windGust, dailyForecastEntity4.windGust)

        val dailyForecastData5 = dailyForecastWeatherData.daily[5]
        val dailyForecastEntity5 = result[5]
        assertEquals(0, dailyForecastEntity5.id)
        assertEquals(dailyForecastData5.dt, dailyForecastEntity5.dt)
        assertEquals(dailyForecastData5.sunrise, dailyForecastEntity5.sunrise)
        assertEquals(dailyForecastData5.sunset, dailyForecastEntity5.sunset)
        assertEquals(dailyForecastData5.summary, dailyForecastEntity5.summary)
        assertEquals(dailyForecastData5.temp?.min, dailyForecastEntity5.minTemp)
        assertEquals(dailyForecastData5.temp?.max, dailyForecastEntity5.maxTemp)
        assertEquals(dailyForecastData5.windSpeed, dailyForecastEntity5.windSpeed)
        assertEquals(dailyForecastData5.windDeg, dailyForecastEntity5.windDeg)
        assertEquals(dailyForecastData5.windGust, dailyForecastEntity5.windGust)

        val dailyForecastData6 = dailyForecastWeatherData.daily[6]
        val dailyForecastEntity6 = result[6]
        assertEquals(0, dailyForecastEntity6.id)
        assertEquals(dailyForecastData6.dt, dailyForecastEntity6.dt)
        assertEquals(dailyForecastData6.sunrise, dailyForecastEntity6.sunrise)
        assertEquals(dailyForecastData6.sunset, dailyForecastEntity6.sunset)
        assertEquals(dailyForecastData6.summary, dailyForecastEntity6.summary)
        assertEquals(dailyForecastData6.temp?.min, dailyForecastEntity6.minTemp)
        assertEquals(dailyForecastData6.temp?.max, dailyForecastEntity6.maxTemp)
        assertEquals(dailyForecastData6.windSpeed, dailyForecastEntity6.windSpeed)
        assertEquals(dailyForecastData6.windDeg, dailyForecastEntity6.windDeg)
        assertEquals(dailyForecastData6.windGust, dailyForecastEntity6.windGust)

        val dailyForecastData7 = dailyForecastWeatherData.daily[7]
        val dailyForecastEntity7 = result[7]
        assertEquals(0, dailyForecastEntity7.id)
        assertEquals(dailyForecastData7.dt, dailyForecastEntity7.dt)
        assertEquals(dailyForecastData7.sunrise, dailyForecastEntity7.sunrise)
        assertEquals(dailyForecastData7.sunset, dailyForecastEntity7.sunset)
        assertEquals(dailyForecastData7.summary, dailyForecastEntity7.summary)
        assertEquals(dailyForecastData7.temp?.min, dailyForecastEntity7.minTemp)
        assertEquals(dailyForecastData7.temp?.max, dailyForecastEntity7.maxTemp)
        assertEquals(dailyForecastData7.windSpeed, dailyForecastEntity7.windSpeed)
        assertEquals(dailyForecastData7.windDeg, dailyForecastEntity7.windDeg)
        assertEquals(dailyForecastData7.windGust, dailyForecastEntity7.windGust)
    }
}
