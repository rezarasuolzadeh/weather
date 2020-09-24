package ir.rezarasuolzadeh.weather.service.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class OfflineWeatherModel(
    @ColumnInfo(name = "weather_id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "weather_temperature") val temperature: Double,
    @ColumnInfo(name = "weather_condition") val condition: String,
    @ColumnInfo(name = "weather_wind_speed") val windSpeed: Double,
    @ColumnInfo(name = "weather_wind_degree") val windDegree: Int,
    @ColumnInfo(name = "weather_pressure") val pressure: Int,
    @ColumnInfo(name = "weather_humidity") val humidity: Int,
    @ColumnInfo(name = "weather_visibility") val visibility: Int,
    @ColumnInfo(name = "weather_icon") val icon: String
)