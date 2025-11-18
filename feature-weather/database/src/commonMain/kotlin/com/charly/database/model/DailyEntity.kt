package com.charly.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//  CREATE TABLE daily_weather_table (
//      id INTEGER PRIMARY KEY AUTOINCREMENT,
//      dt INTEGER,
//      sunrise INTEGER,
//      sunset INTEGER,
//      summary TEXT,
//      minTemp TEXT,
//      maxTemp TEXT
//  );
@Entity(
    tableName = "daily_weather_table"
)
data class DailyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val dt: Long? = null,
    val sunrise: Long? = null,
    val sunset: Long? = null,
    val summary: String? = null,
    val minTemp: String? = null,
    val maxTemp: String? = null
)
