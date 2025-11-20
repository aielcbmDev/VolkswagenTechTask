package com.something.volkswagentechtask

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.charly.weatherapp.di.weatherAppModule
import com.something.volkswagentechtask.di.appModule
import com.something.volkswagentechtask.navigation.WeatherNavigationHost
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

@Composable
@Preview
fun App(koinAppDeclaration: KoinAppDeclaration? = null) {
    KoinApplication(application = {
        koinAppDeclaration?.invoke(this)
        modules(appModule, weatherAppModule)
    }) {
        MaterialTheme {
            WeatherNavigationHost()
        }
    }
}
