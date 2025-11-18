package com.charly.database.di

import androidx.room.RoomDatabase
import com.charly.database.WeatherDatabase
import com.charly.database.createDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val databasePlatformModule: Module
    get() = module {
        factory<RoomDatabase.Builder<WeatherDatabase>> {
            createDatabaseBuilder(context = get())
        }
    }
