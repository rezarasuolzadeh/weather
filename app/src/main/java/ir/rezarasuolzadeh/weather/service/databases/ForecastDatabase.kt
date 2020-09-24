package ir.rezarasuolzadeh.weather.service.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.rezarasuolzadeh.weather.interfaces.database.OfflineForecastDao
import ir.rezarasuolzadeh.weather.service.models.OfflineForecastModel

@Database(entities = [OfflineForecastModel::class], version = 1, exportSchema = false)
abstract class ForecastDatabase : RoomDatabase() {

    abstract fun offlineForecastDao(): OfflineForecastDao

    companion object {
        @Volatile
        private var INSTANCE: ForecastDatabase? = null

        fun getInstance(context: Context): ForecastDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ForecastDatabase::class.java,
                    "forecast_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}