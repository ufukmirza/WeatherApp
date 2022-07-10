package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WeatherDayForecast(state: WeatherState, modifier: Modifier = Modifier) {

    state?.weatherInfo?.weatherDataPerDay?.let { data ->
        LazyColumn() {

            items(data.values.toList()) { weatherDataPerDay ->

                WeatherForecast(weatherPerDay = weatherDataPerDay)
                Spacer(modifier=Modifier.padding(16.dp))

            }

        }


    }


}