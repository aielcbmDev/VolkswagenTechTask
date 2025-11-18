package com.charly.core.database.mappers

import com.charly.database.model.DailyEntity
import com.charly.domain.model.Daily

internal fun Daily.mapToDailyEntity(): DailyEntity {
    return DailyEntity(
        id = id,
        dt = dt,
        sunrise = sunrise,
        sunset = sunset,
        summary = summary,
        minTemp = minTemp,
        maxTemp = maxTemp
    )
}

internal fun List<Daily>.mapToDailyEntityList(): List<DailyEntity> {
    return map { it.mapToDailyEntity() }
}

internal fun DailyEntity.mapToDaily(): Daily {
    return Daily(
        id = id,
        dt = dt,
        sunrise = sunrise,
        sunset = sunset,
        summary = summary,
        minTemp = minTemp,
        maxTemp = maxTemp
    )
}

internal fun List<DailyEntity>.mapToDailyList(): List<Daily> {
    return map { it.mapToDaily() }
}
