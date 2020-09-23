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
    val lon: Int = 0, // 50
    @SerializedName("timezone")
    val timezone: String = "", // Asia/Tehran
    @SerializedName("timezone_offset")
    val timezoneOffset: Int = 0 // 12600
)

data class Current(
    @SerializedName("clouds")
    val clouds: Int = 0, // 20
    @SerializedName("dew_point")
    val dewPoint: Double = 0.0, // 281.98
    @SerializedName("dt")
    val dt: Int = 0, // 1600856484
    @SerializedName("feels_like")
    val feelsLike: Double = 0.0, // 298.01
    @SerializedName("humidity")
    val humidity: Int = 0, // 30
    @SerializedName("pressure")
    val pressure: Int = 0, // 1018
    @SerializedName("sunrise")
    val sunrise: Int = 0, // 1600828127
    @SerializedName("sunset")
    val sunset: Int = 0, // 1600871752
    @SerializedName("temp")
    val temp: Double = 0.0, // 301.15
    @SerializedName("uvi")
    val uvi: Double = 0.0, // 7.31
    @SerializedName("visibility")
    val visibility: Int = 0, // 10000
    @SerializedName("weather")
    val weather: List<ForecastModel> = listOf(),
    @SerializedName("wind_deg")
    val windDeg: Int = 0, // 140
    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0 // 4.1
)

data class Daily(
    @SerializedName("clouds")
    val clouds: Int = 0, // 20
    @SerializedName("dew_point")
    val dewPoint: Double = 0.0, // 281.98
    @SerializedName("dt")
    val dt: Int = 0, // 1600849800
    @SerializedName("feels_like")
    val feelsLike: FeelsLike = FeelsLike(),
    @SerializedName("humidity")
    val humidity: Int = 0, // 30
    @SerializedName("pop")
    val pop: Double = 0.0, // 0.04
    @SerializedName("pressure")
    val pressure: Int = 0, // 1018
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
    val windDeg: Int = 0, // 144
    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0 // 4.78
)

data class Hourly(
    @SerializedName("clouds")
    val clouds: Int = 0, // 20
    @SerializedName("dew_point")
    val dewPoint: Double = 0.0, // 281.98
    @SerializedName("dt")
    val dt: Int = 0, // 1600855200
    @SerializedName("feels_like")
    val feelsLike: Double = 0.0, // 297.93
    @SerializedName("humidity")
    val humidity: Int = 0, // 30
    @SerializedName("pop")
    val pop: Int = 0, // 0
    @SerializedName("pressure")
    val pressure: Int = 0, // 1018
    @SerializedName("temp")
    val temp: Double = 0.0, // 301.15
    @SerializedName("visibility")
    val visibility: Int = 0, // 10000
    @SerializedName("weather")
    val weather: List<WeatherXX> = listOf(),
    @SerializedName("wind_deg")
    val windDeg: Int = 0, // 141
    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0 // 4.21
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
    val day: Double = 0.0, // 297.53
    @SerializedName("eve")
    val eve: Double = 0.0, // 295.51
    @SerializedName("morn")
    val morn: Double = 0.0, // 289.46
    @SerializedName("night")
    val night: Double = 0.0 // 293.54
)

data class Temp(
    @SerializedName("day")
    val day: Double = 0.0, // 301.15
    @SerializedName("eve")
    val eve: Double = 0.0, // 299.32
    @SerializedName("max")
    val max: Double = 0.0, // 301.62
    @SerializedName("min")
    val min: Double = 0.0, // 289.98
    @SerializedName("morn")
    val morn: Double = 0.0, // 290.54
    @SerializedName("night")
    val night: Double = 0.0 // 295.37
)

data class WeatherX(
    @SerializedName("description")
    val description: String = "", // کمی ابری
    @SerializedName("icon")
    val icon: String = "", // 02d
    @SerializedName("id")
    val id: Int = 0, // 801
    @SerializedName("main")
    val main: String = "" // Clouds
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