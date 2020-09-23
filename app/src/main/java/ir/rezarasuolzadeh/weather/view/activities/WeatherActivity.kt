package ir.rezarasuolzadeh.weather.view.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import ir.rezarasuolzadeh.weather.R
import ir.rezarasuolzadeh.weather.service.models.ForecastModel
import ir.rezarasuolzadeh.weather.service.models.WeatherModel
import ir.rezarasuolzadeh.weather.service.utils.Enums
import ir.rezarasuolzadeh.weather.service.utils.WeatherInfo
import ir.rezarasuolzadeh.weather.view.adapters.ForecastAdapter
import ir.rezarasuolzadeh.weather.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity(), Observer<Any?> {

    private val weatherViewModel by viewModel<WeatherViewModel>()
    private val weatherInfo: WeatherInfo by inject()
    private val forecastAdapter: ForecastAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherViewModel.getWeather(
            resources.getString(R.string.city),
            resources.getString(R.string.token)
        ).observe(this, this)

        weatherViewModel.getForecast(
            resources.getString(R.string.lat),
            resources.getString(R.string.lon),
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
            conditionImageView.setImageResource(weatherInfo.generateConditionIcon(response.weather[0].icon))
        }
        if (response is ForecastModel) {
            forecastAdapter.dailyList = response.daily
            forecastAdapter.context = this
            forecastRecyclerView.adapter = forecastAdapter
            waitingLayout.visibility = View.GONE
        }
        if (response is Enums.DataState) {
            if (response == Enums.DataState.FAILED) {
                // offline
                offlineTextView.visibility = View.VISIBLE
            }
        }
        if (response is Enums.NetworkState) {
            if (response == Enums.NetworkState.NO_INTERNET) {
                // offline
                offlineTextView.visibility = View.VISIBLE
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}