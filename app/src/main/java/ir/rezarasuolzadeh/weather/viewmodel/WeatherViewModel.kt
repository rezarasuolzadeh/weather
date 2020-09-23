package ir.rezarasuolzadeh.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ir.rezarasuolzadeh.weather.service.models.ForecastModel
import ir.rezarasuolzadeh.weather.service.models.OfflineWeatherModel
import ir.rezarasuolzadeh.weather.service.models.WeatherModel
import ir.rezarasuolzadeh.weather.service.repositories.OfflineRepository
import ir.rezarasuolzadeh.weather.service.repositories.WeatherRepository
import ir.rezarasuolzadeh.weather.service.utils.Enums
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    fun getWeather(city: String, token: String) = liveData(Dispatchers.IO) {
        runBlocking {
            emit(Enums.DataState.LOADING)
            val response = weatherRepository.getWeather(city, token)
            when (response) {
                null -> {
                    emit(Enums.DataState.FAILED)
                }
                is WeatherModel -> {
                    emit(response)
                }
                is Enums.NetworkState -> {
                    emit(response)
                }
            }
        }
    }

    fun getForecast(lat: String, lon: String, token: String) = liveData(Dispatchers.IO) {
        runBlocking {
            emit(Enums.DataState.LOADING)
            val response = weatherRepository.getForecast(lat, lon, token)
            when (response) {
                null -> {
                    emit(Enums.DataState.FAILED)
                }
                is ForecastModel -> {
                    emit(response)
                }
                is Enums.NetworkState -> {
                    emit(response)
                }
            }
        }
    }

}