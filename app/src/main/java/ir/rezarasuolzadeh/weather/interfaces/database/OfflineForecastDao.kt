package ir.rezarasuolzadeh.weather.interfaces.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.rezarasuolzadeh.weather.service.models.OfflineForecastModel

@Dao
interface OfflineForecastDao {

    @Insert
    suspend fun insertForecast(forecast: OfflineForecastModel)

    @Query("DELETE FROM forecast_table")
    suspend fun deleteForecast()

    @Query("SELECT * FROM forecast_table")
    suspend fun getForecast(): List<OfflineForecastModel>

}