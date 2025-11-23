package com.charly.weatherapp.formatdata.datetime

import com.charly.weatherapp.OpenClassForMocking
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OpenClassForMocking
class TimeFormatter(
    private val timeZone: TimeZone
) {

    @OptIn(ExperimentalTime::class)
    fun formatEpochSecondsToTimeString(epochSeconds: Long?): String? {
        if (epochSeconds == null) return null
        val instant: Instant = Instant.fromEpochSeconds(epochSeconds)
        val datetime: LocalDateTime = instant.toLocalDateTime(timeZone)
        return datetime.formatToTime()
    }
}
