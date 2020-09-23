package ir.rezarasuolzadeh.weather.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import ir.rezarasuolzadeh.weather.R
import ir.rezarasuolzadeh.weather.service.models.WeatherModel
import ir.rezarasuolzadeh.weather.service.utils.Enums
import ir.rezarasuolzadeh.weather.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity(), Observer<Any?> {

    private val weatherViewModel by viewModel<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherViewModel.getWeather(
            resources.getString(R.string.city),
            resources.getString(R.string.token)
        ).observe(this, this)
    }

    override fun onChanged(response: Any?) {
        if (response is WeatherModel) {
            Toast.makeText(this, response.main.humidity.toString(), Toast.LENGTH_SHORT).show()
        }
        if (response is Enums.DataState) {
            if (response == Enums.DataState.FAILED) {
                Toast.makeText(this, "ارتباط با خطا مواجه شد", Toast.LENGTH_SHORT).show()
            }
        }
        if (response is Enums.NetworkState) {
            if (response == Enums.NetworkState.NO_INTERNET) {
                Toast.makeText(this, "عدم اتصال به اینترنت", Toast.LENGTH_SHORT).show()
            }
        }
    }

}