package com.example.action_input_class07

import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

fun getFormattedDateTime(value: Long, format: String) : String{
    return SimpleDateFormat(format).format(Date(value))
}

