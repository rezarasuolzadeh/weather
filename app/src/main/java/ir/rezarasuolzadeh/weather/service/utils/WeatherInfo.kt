package ir.rezarasuolzadeh.weather.service.utils

class WeatherInfo {

    fun generateWindSpeed(speed: Double): String {
        return "سرعت باد: "
            .plus(String.format("%.0f", speed).plus(" متر بر ثانیه"))
            .plus(" | ")
            .plus(String.format("%.0f", speed * 3.6).plus(" کیلومتر بر ساعت"))
    }

    fun generateWindDegree(degree: Int): String {
        return "جهت باد: "
            .plus(
                when (degree) {
                    in 22..67 -> {
                        "شمال شرقی"
                    }
                    in 68..112 -> {
                        "شرقی"
                    }
                    in 113..157 -> {
                        "جنوب شرقی"
                    }
                    in 158..202 -> {
                        "جنوبی"
                    }
                    in 203..247 -> {
                        "جنوب غربی"
                    }
                    in 248..292 -> {
                        "غربی"
                    }
                    in 293..337 -> {
                        "شمال غربی"
                    }
                    else -> {
                        "شمالی"
                    }
                }
            )
            .plus(" (°$degree)")
    }

    fun generateTemperature(temperature: Double): String {
        return String.format("%.0f", temperature).plus("°c")
    }

    fun generateCondition(condition: String): String {
        return condition
    }

    fun generatePressure(pressure: Int): String {
        return pressure.toString().plus(" hPa\n").plus("فشار هوا")
    }

    fun generateHumidity(humidity: Int): String {
        return humidity.toString().plus("%\n").plus("نم نسبی")
    }

    fun generateVisibility(visibility: Int): String {
        return (visibility / 1000).toString().plus(" km\n").plus("دید افقی")
    }

}