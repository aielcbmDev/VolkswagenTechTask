package com.charly.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.charly.database.model.DailyDao
import com.charly.database.model.DailyForecastEntity

@Database(
    entities = [DailyForecastEntity::class],
    version = 1
)
@ConstructedBy(WeatherDatabaseConstructor::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun getDailyDao(): DailyDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object WeatherDatabaseConstructor : RoomDatabaseConstructor<WeatherDatabase> {
    override fun initialize(): WeatherDatabase
}
