package ir.rezarasuolzadeh.weather.interfaces.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.rezarasuolzadeh.weather.service.models.OfflineWeatherModel

@Dao
interface OfflineWeatherDao {

    @Insert
    suspend fun insertWeather(weather: OfflineWeatherModel)

    @Query("DELETE FROM weather_table")
    suspend fun deleteWeather()

    @Query("SELECT * FROM weather_table")
    suspend fun getWeather(): List<OfflineWeatherModel>

}