package com.charly.database.utils

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.charly.database.WeatherDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun RoomDatabase.Builder<WeatherDatabase>.getRoomDatabase(): WeatherDatabase {
    return addMigrations()
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
