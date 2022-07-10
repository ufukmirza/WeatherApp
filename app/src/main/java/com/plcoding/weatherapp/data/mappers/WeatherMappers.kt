package com.plcoding.weatherapp.data.mappers

import android.util.Log
import com.plcoding.weatherapp.data.remote.WeatherDataDto
import com.plcoding.weatherapp.data.remote.WeatherDto
import com.plcoding.weatherapp.domain.weather.WeatherData
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private data class IndexedWeatherData(
    val index: Int,
    val weatherData: WeatherData
)

fun WeatherDataDto.ToWeatherDataMap(): Map<Int, List<WeatherData>> {

    return time.mapIndexed { index, time ->

        val temperatureCelsius = temperature[index]
        val windSpeed = windSpeed[index]
        val humidity = relativeHumidity[index]
        val pressure = pressureMsl[index]
        val weatherCode = weatherCode[index]

        IndexedWeatherData(
            index = index, weatherData =
            WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperatureCelsius,
                windSpeed = windSpeed,
                humidity = humidity,
                pressure = pressure,
                weatherType = WeatherType.fromWMO(weatherCode),
            )
        )

    }.groupBy {

        it.index / 24

    }.mapValues {
        it.value.map { it.weatherData }
    }


}


fun WeatherDto.toWeatherInfo(): WeatherInfo {

    val weatherInfo = weatherData.ToWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherInfo = weatherInfo[0]?.find {

        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }


    weatherInfo[0]?.get(3)?.time?.toString()?.let { Log.d("controlWeather", it) }
    return WeatherInfo(
        currentWeatherData = currentWeatherInfo,
        weatherDataPerDay = weatherInfo
    )


}