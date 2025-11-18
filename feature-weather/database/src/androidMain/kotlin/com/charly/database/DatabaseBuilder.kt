package com.charly.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE_NAME = "weather_android.db"

fun createDatabaseBuilder(
    context: Context
): RoomDatabase.Builder<WeatherDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<WeatherDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
