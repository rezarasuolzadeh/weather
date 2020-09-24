package ir.rezarasuolzadeh.weather.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasuolzadeh.weather.R
import ir.rezarasuolzadeh.weather.service.models.OfflineForecastModel
import ir.rezarasuolzadeh.weather.service.utils.WeatherInfo
import kotlinx.android.synthetic.main.model_forecast.view.*

class OfflineForecastAdapter(private val weatherInfo: WeatherInfo) : RecyclerView.Adapter<OfflineForecastAdapter.OfflineForecastViewHolder>() {

    var dailyList: List<OfflineForecastModel>? = null
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfflineForecastViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.model_forecast, parent, false)
        return OfflineForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dailyList!!.size - 1
    }

    override fun onBindViewHolder(holder: OfflineForecastViewHolder, position: Int) {
        holder.bind(dailyList!![position], position)
    }

    inner class OfflineForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(daily: OfflineForecastModel, day: Int) {
            itemView.dayTextView.text = weatherInfo.generateDays(day)
            itemView.conditionImageView.setImageResource(weatherInfo.generateConditionIcon(daily.icon))
            itemView.conditionTextView.text = weatherInfo.generateCondition(daily.condition)
            itemView.temperatureTextView.text = weatherInfo.generateTemperature(daily.temperature)
        }
    }

}