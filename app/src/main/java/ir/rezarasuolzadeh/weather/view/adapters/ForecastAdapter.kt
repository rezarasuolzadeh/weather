package ir.rezarasuolzadeh.weather.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.rezarasuolzadeh.weather.R
import ir.rezarasuolzadeh.weather.service.models.Daily
import ir.rezarasuolzadeh.weather.service.models.ForecastModel
import kotlinx.android.synthetic.main.model_forecast.view.*

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    var subsetsList: List<Daily>? = null
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_forecast, parent, false)
        return ForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subsetsList!!.size
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(subsetsList!![position])
    }

    inner class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(users: Daily) {
            itemView.conditionImageView.text = users.firstName.plus(" ${users.lastName}")
            itemView.conditionTextView.text = Translator.getFaRole(users.role)
        }
    }

}