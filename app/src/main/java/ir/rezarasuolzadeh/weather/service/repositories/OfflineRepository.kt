package ir.rezarasuolzadeh.weather.service.repositories

import ir.rezarasuolzadeh.weather.interfaces.database.OfflineForecastDao
import ir.rezarasuolzadeh.weather.interfaces.database.OfflineWeatherDao
import ir.rezarasuolzadeh.weather.service.models.OfflineForecastModel
import ir.rezarasuolzadeh.weather.service.models.OfflineWeatherModel

class OfflineRepository(
    private val offlineWeatherDao: OfflineWeatherDao,
    private val offlineForecastDao: OfflineForecastDao
) {

    suspend fun insertWeather(weather: OfflineWeatherModel) {
        offlineWeatherDao.insertWeather(weather)
    }

    suspend fun deleteWeather() {
        offlineWeatherDao.deleteWeather()
    }

    suspend fun getWeather(): List<OfflineWeatherModel> {
        return offlineWeatherDao.getWeather()
    }

    suspend fun insertForecast(forecast: OfflineForecastModel) {
        offlineForecastDao.insertForecast(forecast)
    }

    suspend fun deleteForecast() {
        offlineForecastDao.deleteForecast()
    }

    suspend fun getForecast(): List<OfflineForecastModel> {
        return offlineForecastDao.getForecast()
    }

}