package ir.rezarasuolzadeh.weather.service.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecast_table")
data class OfflineForecastModel(
    @ColumnInfo(name = "forecast_id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "forecast_temperature") val temperature: Double,
    @ColumnInfo(name = "forecast_condition") val condition: String,
    @ColumnInfo(name = "forecast_icon") val icon: String
)