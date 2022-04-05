package com.example.action_input_class07

val cityList = listOf<String>("Dhaka","Tangail","Chittagong","Khulna","Rajshahi","Bhola","Comilla","Kuakata","Bandarban","Khagrachari")

val busTypeEconomy = "Economy"
val busTypeBusiness = "Business"

data class BusSchedule(
    val id: Long,
    val busName: String,
    val fromCity: String,
    val toCity: String,
    val departureDate: String,
    val departureTime: String,
    val busType: String
)

val scheduleList = mutableListOf<BusSchedule>()