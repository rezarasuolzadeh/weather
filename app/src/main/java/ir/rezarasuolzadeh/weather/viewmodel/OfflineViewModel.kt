package ir.rezarasuolzadeh.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ir.rezarasuolzadeh.weather.service.models.OfflineWeatherModel
import ir.rezarasuolzadeh.weather.service.repositories.OfflineRepository
import ir.rezarasuolzadeh.weather.service.utils.Enums
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class OfflineViewModel(private val offlineRepository: OfflineRepository) : ViewModel() {

    fun insertWeather(weather: OfflineWeatherModel) = liveData(Dispatchers.IO) {
        runBlocking {
            val response = offlineRepository.insertWeather(weather)
            emit(response)
        }
    }

    fun deleteWeather() = liveData(Dispatchers.IO) {
        runBlocking {
            val response = offlineRepository.deleteWeather()
            emit(response)
        }
    }

    fun getWeather() :LiveData<List<OfflineWeatherModel>> = liveData(Dispatchers.IO) {
        runBlocking {
            delay(1000)
            val response = offlineRepository.getWeather()
            delay(1000)
            emit(response)
        }
    }

}