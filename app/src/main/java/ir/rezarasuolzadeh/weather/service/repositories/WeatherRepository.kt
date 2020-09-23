package ir.rezarasuolzadeh.weather.service.repositories

import android.util.Log
import ir.rezarasuolzadeh.weather.interfaces.api.WeatherDao
import ir.rezarasuolzadeh.weather.service.utils.Enums

class WeatherRepository(private val weatherDao: WeatherDao) {

    private val unit = "Metric"
    private val language = "fa"

    suspend fun getWeather(city: String, token: String): Any? {
        return try {
            val response = weatherDao.getWeather(city, token, unit, language)
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