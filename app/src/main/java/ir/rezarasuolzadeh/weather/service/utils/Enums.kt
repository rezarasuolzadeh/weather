package ir.rezarasuolzadeh.weather.service.utils

class Enums {
    enum class DataState { LOADING, DONE, FAILED, NOT_STARTED , NETWORK_ERROR}
    enum class NetworkState { NO_INTERNET, SERVER_ERROR}
}