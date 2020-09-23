package ir.rezarasuolzadeh.weather.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasuolzadeh.weather.R
import ir.rezarasuolzadeh.weather.service.models.Daily
import ir.rezarasuolzadeh.weather.service.utils.WeatherInfo
import kotlinx.android.synthetic.main.model_forecast.view.*

class ForecastAdapter(private val weatherInfo: WeatherInfo) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    var dailyList: List<Daily>? = null
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.model_forecast, parent, false)
        return ForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dailyList!!.size - 1
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(dailyList!![position], position)
    }

    inner class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(daily: Daily, day: Int) {
            itemView.dayTextView.text = weatherInfo.generateDays(day)
            itemView.conditionImageView.setImageResource(weatherInfo.generateConditionIcon(daily.weather[0].icon))
            itemView.conditionTextView.text = weatherInfo.generateCondition(daily.weather[0].description)
            itemView.temperatureTextView.text = weatherInfo.generateTemperature(daily.temp.day)
        }
    }

}