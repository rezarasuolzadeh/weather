package ir.rezarasuolzadeh.weather.interfaces.api

import ir.rezarasuolzadeh.weather.service.models.ForecastModel
import ir.rezarasuolzadeh.weather.service.models.WeatherModel
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface WeatherDao {

    @POST("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") token: String,
        @Query("lang") language: String,
        @Query("units") unit: String
    ): Response<WeatherModel>

    @POST("onecall")
    suspend fun getForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") token: String,
        @Query("lang") language: String,
        @Query("units") unit: String,
        @Query("exclude") exclude: String
    ): Response<ForecastModel>

}