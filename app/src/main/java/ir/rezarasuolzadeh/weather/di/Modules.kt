package ir.rezarasuolzadeh.weather.di

import android.content.Context
import ir.rezarasuolzadeh.weather.interfaces.api.WeatherDao
import ir.rezarasuolzadeh.weather.interfaces.database.OfflineWeatherDao
import ir.rezarasuolzadeh.weather.service.databases.WeatherDatabase
import ir.rezarasuolzadeh.weather.service.repositories.OfflineRepository
import ir.rezarasuolzadeh.weather.service.repositories.WeatherRepository
import ir.rezarasuolzadeh.weather.service.utils.WeatherInfo
import ir.rezarasuolzadeh.weather.view.adapters.ForecastAdapter
import ir.rezarasuolzadeh.weather.viewmodel.OfflineViewModel
import ir.rezarasuolzadeh.weather.viewmodel.WeatherViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// network module
val networkModule = module {
    factory { provideHttpInterceptor() }
    factory { okHttpClientProvider(get()) }
    factory { retrofitProvider(get()) }
}

// weather module
val weatherPageModule = module(override = true) {
    viewModel { WeatherViewModel(get()) }
    viewModel { OfflineViewModel(get()) }
    single { WeatherRepository(get()) }
    single { OfflineRepository(get()) }
    single { weatherDaoProvider(get()) }
    single { WeatherInfo() }
    single { ForecastAdapter(get()) }
    single { offlineWeatherDaoProvider(get()) }
}

// weather dao provider
fun weatherDaoProvider(retrofit: Retrofit): WeatherDao = retrofit.create(WeatherDao::class.java)

// offline weather dao provider
fun offlineWeatherDaoProvider(context: Context): OfflineWeatherDao = WeatherDatabase.getInstance(context).offlineWeatherDao()

// network providers
fun retrofitProvider(httpClient: OkHttpClient): Retrofit {
    val url = "https://api.openweathermap.org/data/2.5/"
    return Retrofit.Builder().baseUrl(url).client(httpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideHttpInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }
}

fun okHttpClientProvider(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .retryOnConnectionFailure(true)
        .build()
}