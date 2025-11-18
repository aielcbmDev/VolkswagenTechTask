package com.charly.networking.di

import com.charly.networking.engine.DarwinEngineProvider
import io.ktor.client.engine.HttpClientEngine
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val networkingPlatformModule: Module
    get() = module {
        single<HttpClientEngine> {
            DarwinEngineProvider().create()
        }
    }
