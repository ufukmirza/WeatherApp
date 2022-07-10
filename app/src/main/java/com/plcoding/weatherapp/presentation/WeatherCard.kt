package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.weatherapp.R
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import com.plcoding.weatherapp.presentation.ui.theme.DeepBlue
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt


@Composable
fun WeatherCard(state: WeatherState, backgroundColor: Color, modifier: Modifier = Modifier) {


    state.weatherInfo?.currentWeatherData?.let { data ->


        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(4.dp),
            modifier = modifier.padding(14.dp)
        ) {

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = data.time.format(DateTimeFormatter.ofPattern("HH:MM")),
                    textAlign = TextAlign.Right,
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = "weather type",
                    modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = "${data.temperatureCelsius}°C",
                    fontSize = 50.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherDataDisplay(
                        value = data.pressure.roundToInt(),
                        unit = "hpa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                }


            }


        }


    }


}


@Preview
@Composable
fun WeatherCardPreview() {

   // WeatherCard(state = WeatherState(weatherInfo = WeatherInfo()), backgroundColor = DeepBlue)


}