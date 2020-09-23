package ir.rezarasuolzadeh.weather.service.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class OfflineWeatherModel(
    @ColumnInfo(name = "weather_id") @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "weather_temperature") var temperature: Double,
    @ColumnInfo(name = "weather_condition") var condition: String,
    @ColumnInfo(name = "weather_wind_speed") var windSpeed: Double,
    @ColumnInfo(name = "weather_wind_degree") var windDegree: Int,
    @ColumnInfo(name = "weather_pressure") var pressure: Int,
    @ColumnInfo(name = "weather_humidity") var humidity: Int,
    @ColumnInfo(name = "weather_visibility") var visibility: Int,
    @ColumnInfo(name = "weather_icon") var icon: String
)