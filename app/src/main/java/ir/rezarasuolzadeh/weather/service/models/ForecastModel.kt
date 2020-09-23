package ir.rezarasuolzadeh.weather.service.models

import com.google.gson.annotations.SerializedName

data class ForecastModel(
    @SerializedName("current")
    val current: Current = Current(),
    @SerializedName("daily")
    val daily: List<Daily> = listOf(),
    @SerializedName("hourly")
    val hourly: List<Hourly> = listOf(),
    @SerializedName("lat")
    val lat: Double = 0.0, // 36.27
    @SerializedName("lon")
    val lon: Double = 0.0, // 50
    @SerializedName("timezone")
    val timezone: String = "", // Asia/Tehran
    @SerializedName("timezone_offset")
    val timezoneOffset: Int = 0 // 12600
)

data class Current(
    @SerializedName("clouds")
    val clouds: Int = 0, // 20
    @SerializedName("dew_point")
    val dewPoint: Double = 0.0, // 7.57
    @SerializedName("dt")
    val dt: Int = 0, // 1600866290
    @SerializedName("feels_like")
    val feelsLike: Double = 0.0, // 24.86
    @SerializedName("humidity")
    val humidity: Int = 0, // 26
    @SerializedName("pressure")
    val pressure: Int = 0, // 1017
    @SerializedName("sunrise")
    val sunrise: Int = 0, // 1600828127
    @SerializedName("sunset")
    val sunset: Int = 0, // 1600871752
    @SerializedName("temp")
    val temp: Double = 0.0, // 29
    @SerializedName("uvi")
    val uvi: Double = 0.0, // 7.31
    @SerializedName("visibility")
    val visibility: Int = 0, // 10000
    @SerializedName("weather")
    val weather: List<ForecastWeather> = listOf(),
    @SerializedName("wind_deg")
    val windDeg: Int = 0, // 120
    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0 // 5.1
)

data class Daily(
    @SerializedName("clouds")
    val clouds: Int = 0, // 0
    @SerializedName("dew_point")
    val dewPoint: Double = 0.0, // 5.95
    @SerializedName("dt")
    val dt: Int = 0, // 1600849800
    @SerializedName("feels_like")
    val feelsLike: FeelsLike = FeelsLike(),
    @SerializedName("humidity")
    val humidity: Int = 0, // 26
    @SerializedName("pop")
    val pop: Double = 0.0, // 0.04
    @SerializedName("pressure")
    val pressure: Int = 0, // 1017
    @SerializedName("sunrise")
    val sunrise: Int = 0, // 1600828127
    @SerializedName("sunset")
    val sunset: Int = 0, // 1600871752
    @SerializedName("temp")
    val temp: Temp = Temp(),
    @SerializedName("uvi")
    val uvi: Double = 0.0, // 7.31
    @SerializedName("weather")
    val weather: List<WeatherX> = listOf(),
    @SerializedName("wind_deg")
    val windDeg: Int = 0, // 143
    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0 // 4.75
)

data class Hourly(
    @SerializedName("clouds")
    val clouds: Int = 0, // 20
    @SerializedName("dew_point")
    val dewPoint: Double = 0.0, // 7.57
    @SerializedName("dt")
    val dt: Int = 0, // 1600866000
    @SerializedName("feels_like")
    val feelsLike: Double = 0.0, // 24.96
    @SerializedName("humidity")
    val humidity: Int = 0, // 26
    @SerializedName("pop")
    val pop: Int = 0, // 0
    @SerializedName("pressure")
    val pressure: Int = 0, // 1017
    @SerializedName("temp")
    val temp: Double = 0.0, // 29
    @SerializedName("visibility")
    val visibility: Int = 0, // 10000
    @SerializedName("weather")
    val weather: List<WeatherXX> = listOf(),
    @SerializedName("wind_deg")
    val windDeg: Int = 0, // 115
    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0 // 4.95
)

data class ForecastWeather(
    @SerializedName("description")
    val description: String = "", // کمی ابری
    @SerializedName("icon")
    val icon: String = "", // 02d
    @SerializedName("id")
    val id: Int = 0, // 801
    @SerializedName("main")
    val main: String = "" // Clouds
)

data class FeelsLike(
    @SerializedName("day")
    val day: Double = 0.0, // 22.68
    @SerializedName("eve")
    val eve: Double = 0.0, // 23.57
    @SerializedName("morn")
    val morn: Double = 0.0, // 16.31
    @SerializedName("night")
    val night: Double = 0.0 // 21.79
)

data class Temp(
    @SerializedName("day")
    val day: Double = 0.0, // 26.96
    @SerializedName("eve")
    val eve: Double = 0.0, // 27.42
    @SerializedName("max")
    val max: Double = 0.0, // 29
    @SerializedName("min")
    val min: Double = 0.0, // 16.83
    @SerializedName("morn")
    val morn: Double = 0.0, // 17.39
    @SerializedName("night")
    val night: Double = 0.0 // 23.62
)

data class WeatherX(
    @SerializedName("description")
    val description: String = "", // آسمان صاف
    @SerializedName("icon")
    val icon: String = "", // 01d
    @SerializedName("id")
    val id: Int = 0, // 800
    @SerializedName("main")
    val main: String = "" // Clear
)

data class WeatherXX(
    @SerializedName("description")
    val description: String = "", // کمی ابری
    @SerializedName("icon")
    val icon: String = "", // 02d
    @SerializedName("id")
    val id: Int = 0, // 801
    @SerializedName("main")
    val main: String = "" // Clouds
)