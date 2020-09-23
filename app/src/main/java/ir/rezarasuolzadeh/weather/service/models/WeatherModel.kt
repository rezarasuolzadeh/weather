package ir.rezarasuolzadeh.weather.service.models
import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("base")
    val base: String = "", // stations
    @SerializedName("clouds")
    val clouds: Clouds = Clouds(),
    @SerializedName("cod")
    val cod: Int = 0, // 200
    @SerializedName("coord")
    val coord: Coord = Coord(),
    @SerializedName("dt")
    val dt: Int = 0, // 1600844108
    @SerializedName("id")
    val id: Int = 0, // 119505
    @SerializedName("main")
    val main: Main = Main(),
    @SerializedName("name")
    val name: String = "", // Qazvin
    @SerializedName("sys")
    val sys: Sys = Sys(),
    @SerializedName("timezone")
    val timezone: Int = 0, // 12600
    @SerializedName("visibility")
    val visibility: Int = 0, // 10000
    @SerializedName("weather")
    val weather: List<Weather> = listOf(),
    @SerializedName("wind")
    val wind: Wind = Wind()
)

data class Clouds(
    @SerializedName("all")
    val all: Int = 0 // 0
)

data class Coord(
    @SerializedName("lat")
    val lat: Double = 0.0, // 36.28
    @SerializedName("lon")
    val lon: Int = 0 // 50
)

data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double = 0.0, // 295.58
    @SerializedName("humidity")
    val humidity: Int = 0, // 53
    @SerializedName("pressure")
    val pressure: Int = 0, // 1021
    @SerializedName("temp")
    val temp: Double = 0.0, // 296.15
    @SerializedName("temp_max")
    val tempMax: Double = 0.0, // 296.15
    @SerializedName("temp_min")
    val tempMin: Double = 0.0 // 296.15
)

data class Sys(
    @SerializedName("country")
    val country: String = "", // IR
    @SerializedName("id")
    val id: Int = 0, // 7465
    @SerializedName("sunrise")
    val sunrise: Int = 0, // 1600828127
    @SerializedName("sunset")
    val sunset: Int = 0, // 1600871752
    @SerializedName("type")
    val type: Int = 0 // 1
)

data class Weather(
    @SerializedName("description")
    val description: String = "", // clear sky
    @SerializedName("icon")
    val icon: String = "", // 01d
    @SerializedName("id")
    val id: Int = 0, // 800
    @SerializedName("main")
    val main: String = "" // Clear
)

data class Wind(
    @SerializedName("deg")
    val deg: Int = 0, // 50
    @SerializedName("speed")
    val speed: Double = 0.0 // 2.1
)