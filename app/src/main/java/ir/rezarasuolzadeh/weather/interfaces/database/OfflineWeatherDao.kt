package ir.rezarasuolzadeh.weather.interfaces.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.rezarasuolzadeh.weather.service.models.OfflineWeatherModel

@Dao
interface OfflineWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: OfflineWeatherModel) : Long

    @Query("DELETE FROM weather_table")
    suspend fun deleteWeather()

    @Query("SELECT * FROM weather_table")
    suspend fun getWeather(): List<OfflineWeatherModel>

}