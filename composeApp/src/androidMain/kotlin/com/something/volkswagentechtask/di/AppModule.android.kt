package com.something.volkswagentechtask.di

import com.something.volkswagentechtask.apisecrets.WeatherApiSecrets
import com.something.volkswagentechtask.apisecrets.WeatherApiSecretsImpl
import com.something.volkswagentechtask.utils.BuildConfig
import com.something.volkswagentechtask.utils.BuildConfigImpl
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val appPlatformModule: Module
    get() = module {
        factory<WeatherApiSecrets> { WeatherApiSecretsImpl() }
        factory<BuildConfig> { BuildConfigImpl(get()) }
    }
