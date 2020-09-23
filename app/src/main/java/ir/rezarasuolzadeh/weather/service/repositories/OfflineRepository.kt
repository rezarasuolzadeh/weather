package ir.rezarasuolzadeh.weather.service.repositories

import ir.rezarasuolzadeh.weather.interfaces.database.OfflineWeatherDao
import ir.rezarasuolzadeh.weather.service.models.OfflineWeatherModel

class OfflineRepository(private val offlineWeatherDao: OfflineWeatherDao) {

    suspend fun insertWeather(weather: OfflineWeatherModel) {
        offlineWeatherDao.insertWeather(weather)
    }

    suspend fun deleteWeather(){
        offlineWeatherDao.deleteWeather()
    }

    suspend fun getWeather() : OfflineWeatherModel{
        return offlineWeatherDao.getWeather()
    }

}