package com.plcoding.weatherapp.presentation


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.weatherapp.data.location.DefaultLocationTracker
import com.plcoding.weatherapp.domain.location.LocationTracker
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    val weatherRepository: WeatherRepository,
    val locationTracker: LocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set


    fun loadWeatherInfo() {

        viewModelScope.launch {

            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
              Log.d("location","${location.latitude}, ${location.longitude}")
                when (val result =
                    weatherRepository.getWeatherData(location.latitude, location.longitude)) {

                    is Resource.Success -> {

                        state =
                            state.copy(weatherInfo = result.data, isLoading = false, error = null)
                        Log.d("uyari",result.data?.weatherDataPerDay?.get(0)?.get(0)?.time.toString())


                    }
                    is Resource.Error -> {
                        state =
                            state.copy(
                                weatherInfo = null,
                                isLoading = false,
                                error = result.message
                            )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }
}