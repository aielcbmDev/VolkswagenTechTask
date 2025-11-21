package com.charly.weatherapp.model

/**
 * Temperature is available in Fahrenheit, Celsius and Kelvin units.
 * Wind speed is available in miles/hour and meter/sec.
 *
 * For temperature in Fahrenheit and wind speed in miles/hour, use units=imperial
 * For temperature in Celsius and wind speed in meter/sec, use units=metric
 * Temperature in Kelvin and wind speed in meter/sec is used by default, so there is no need to use
 * the units parameter in the API call if you want this
 */
enum class WeatherUnits(val units: String) {
    STANDARD("standard"),
    METRIC("metric"),
    IMPERIAL("imperial")
}
