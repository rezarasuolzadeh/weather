package ir.rezarasuolzadeh.weather.interfaces.api

import ir.rezarasuolzadeh.weather.service.models.WeatherModel
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface WeatherDao {

    @POST("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") token: String,
        @Query("units") unit: String,
        @Query("lang") language: String
    ): Response<WeatherModel>

}