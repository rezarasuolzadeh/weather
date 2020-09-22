package ir.rezarasuolzadeh.weather.service.config

import android.app.Application
import ir.rezarasuolzadeh.weather.di.networkModule
import ir.rezarasuolzadeh.weather.di.weatherPageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                networkModule,
                weatherPageModule
            )
        }
    }

}