package ir.rezarasuolzadeh.weather.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import ir.rezarasuolzadeh.weather.R
import ir.rezarasuolzadeh.weather.service.models.WeatherModel
import ir.rezarasuolzadeh.weather.service.utils.Enums
import ir.rezarasuolzadeh.weather.service.utils.WeatherInfo
import ir.rezarasuolzadeh.weather.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity(), Observer<Any?> {

    private val weatherViewModel by viewModel<WeatherViewModel>()
    private val weatherInfo: WeatherInfo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherViewModel.getWeather(
            resources.getString(R.string.city),
            resources.getString(R.string.token)
        ).observe(this, this)
    }

    override fun onChanged(response: Any?) {
        if (response is WeatherModel) {
            temperatureTextView.text = weatherInfo.generateTemperature(response.main.temp)
            conditionTextView.text = weatherInfo.generateCondition(response.weather[0].description)
            pressureTextView.text = weatherInfo.generatePressure(response.main.pressure)
            humidityTextView.text = weatherInfo.generateHumidity(response.main.humidity)
            visibilityTextView.text = weatherInfo.generateVisibility(response.visibility)
            windSpeedTextView.text = weatherInfo.generateWindSpeed(response.wind.speed)
            windDegreeTextView.text = weatherInfo.generateWindDegree(response.wind.deg)
        }
        if (response is Enums.DataState) {
            if (response == Enums.DataState.FAILED) {
                Toast.makeText(this, "ارتباط با خطا مواجه شد", Toast.LENGTH_SHORT).show()
            }
        }
        if (response is Enums.NetworkState) {
            if (response == Enums.NetworkState.NO_INTERNET) {
                Toast.makeText(this, "عدم اتصال به اینترنت", Toast.LENGTH_SHORT).show()
            }
        }
    }

}