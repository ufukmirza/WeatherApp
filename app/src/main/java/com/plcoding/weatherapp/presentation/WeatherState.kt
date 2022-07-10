package com.plcoding.weatherapp.presentation


import com.plcoding.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    var weatherInfo:WeatherInfo?=null,
    var isLoading: Boolean=false,
    var error:String?=null
)
