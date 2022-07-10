package com.plcoding.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(value = "v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
suspend fun getWeatherData(
    @Query(value = "latitude") lat:Double?,
    @Query(value = "longitude") long:Double?,
):WeatherDto

}