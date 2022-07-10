package com.plcoding.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(

    @field:Json(name="windspeed_10m") val windSpeed:List<Double>,
    @field:Json(name="relativehumidity_2m") val relativeHumidity:List<Double>,
    @field:Json(name="pressure_msl") val pressureMsl:List<Double>,
    @field:Json(name="temperature_2m") val temperature:List<Double>,
    @field:Json(name="weathercode") val weatherCode:List<Int>,
    @field:Json(name="time") val time:List<String>,

)
