package ir.rezarasuolzadeh.weather.service.repositories

import android.util.Log
import ir.rezarasuolzadeh.weather.interfaces.api.WeatherDao
import ir.rezarasuolzadeh.weather.service.utils.Enums

class WeatherRepository(private val weatherDao: WeatherDao) {

    private val language = "fa"
    private val unit = "Metric"
    private val exclude = "Metric"

    suspend fun getWeather(city: String, token: String): Any? {
        return try {
            val response = weatherDao.getWeather(city, token, language, unit)
            if (response.isSuccessful && response.body() != null) {
                response.body()!!
            } else {
                null
            }
        } catch (e: Exception) {
            Log.i("fetch data :", e.message.toString())
            Enums.NetworkState.NO_INTERNET
        }
    }

    suspend fun getForecast(lat: String, lon: String, token: String): Any? {
        return try {
            val response = weatherDao.getForecast(lat, lon, token, language, unit, exclude)
            if (response.isSuccessful && response.body() != null) {
                response.body()!!
            } else {
                null
            }
        } catch (e: Exception) {
            Log.i("fetch data :", e.message.toString())
            Enums.NetworkState.NO_INTERNET
        }
    }

}