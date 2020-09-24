package ir.rezarasuolzadeh.weather.view.activities

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import ir.rezarasuolzadeh.weather.R
import ir.rezarasuolzadeh.weather.service.models.*
import ir.rezarasuolzadeh.weather.service.utils.Enums
import ir.rezarasuolzadeh.weather.service.utils.WeatherInfo
import ir.rezarasuolzadeh.weather.view.adapters.ForecastAdapter
import ir.rezarasuolzadeh.weather.view.adapters.OfflineForecastAdapter
import ir.rezarasuolzadeh.weather.viewmodel.OfflineViewModel
import ir.rezarasuolzadeh.weather.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity(), Observer<Any?> {

    private val weatherViewModel by viewModel<WeatherViewModel>()
    private val offlineViewModel by viewModel<OfflineViewModel>()
    private val weatherInfo: WeatherInfo by inject()
    private val forecastAdapter: ForecastAdapter by inject()
    private val offlineForecastAdapter: OfflineForecastAdapter by inject()

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
            updateWeatherCache(response)
        }
        if (response is ForecastModel) {
            forecastAdapter.dailyList = response.daily
            forecastAdapter.context = this
            forecastRecyclerView.adapter = forecastAdapter
            waitingLayout.visibility = View.GONE
            updateForecastCache(response.daily)
        }
        if (response is Enums.DataState) {
            if (response == Enums.DataState.FAILED) {
                Toast.makeText(this, "ارتباط با خطا مواجه شد", Toast.LENGTH_SHORT).show()
            }
        }
        if (response is Enums.NetworkState) {
            if (response == Enums.NetworkState.NO_INTERNET) {
                readWeatherCache()
                readForecastCache()
            }
        }
    }

    private fun updateWeatherCache(response: WeatherModel) {
        val weather = OfflineWeatherModel(
            1,
            response.main.temp,
            response.weather[0].description,
            response.wind.speed,
            response.wind.deg,
            response.main.pressure,
            response.main.humidity,
            response.visibility,
            response.weather[0].icon
        )
        offlineViewModel.deleteWeather()
        Handler().postDelayed({
            offlineViewModel.insertWeather(weather)
        }, 1000)
    }

    private fun updateForecastCache(response: List<Daily>) {
        offlineViewModel.deleteForecast()
        Handler().postDelayed({
            for (i in response.indices) {
                offlineViewModel.insertForecast(
                    OfflineForecastModel(
                        i,
                        response[i].temp.day,
                        response[i].weather[0].description,
                        response[i].weather[0].icon
                    )
                )
            }
        }, 1000)
    }

    private fun readWeatherCache() {
        offlineViewModel.getWeather().observe(this, Observer {
            if (it.isEmpty()) {
                Toast.makeText(this, "به اینترنت متصل شوید", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "W" + it.size.toString(), Toast.LENGTH_SHORT).show()
//                temperatureTextView.text = weatherInfo.generateTemperature(it[0].temperature)
//                conditionTextView.text = weatherInfo.generateCondition(it[0].condition)
//                pressureTextView.text = weatherInfo.generatePressure(it[0].pressure)
//                humidityTextView.text = weatherInfo.generateHumidity(it[0].humidity)
//                visibilityTextView.text = weatherInfo.generateVisibility(it[0].visibility)
//                windSpeedTextView.text = weatherInfo.generateWindSpeed(it[0].windSpeed)
//                windDegreeTextView.text = weatherInfo.generateWindDegree(it[0].windDegree)
//                conditionImageView.setImageResource(weatherInfo.generateConditionIcon(it[0].icon))
//                offlineTextView.visibility = View.VISIBLE
//                waitingLayout.visibility = View.GONE
            }
        })
    }

    private fun readForecastCache() {
        offlineViewModel.getForecast().observe(this, Observer {
            if (it.isEmpty()) {
                Toast.makeText(this, "به اینترنت متصل شوید", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "F" + it.size.toString(), Toast.LENGTH_SHORT).show()
//                offlineForecastAdapter.dailyList = it
//                offlineForecastAdapter.context = this
//                forecastRecyclerView.adapter = offlineForecastAdapter
//                offlineForecastAdapter.notifyDataSetChanged()
//                waitingLayout.visibility = View.GONE
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}