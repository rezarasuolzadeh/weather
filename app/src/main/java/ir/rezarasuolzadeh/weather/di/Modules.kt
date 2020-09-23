package ir.rezarasuolzadeh.weather.di

import ir.rezarasuolzadeh.weather.interfaces.api.WeatherDao
import ir.rezarasuolzadeh.weather.service.repositories.WeatherRepository
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
    single { WeatherRepository(get()) }
    single { weatherDaoProvider(get()) }
}

// weather dao provider
fun weatherDaoProvider(retrofit: Retrofit): WeatherDao = retrofit.create(WeatherDao::class.java)

// network providers
fun retrofitProvider(httpClient: OkHttpClient): Retrofit {
    val url = "http://api.openweathermap.org/data/2.5/"
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