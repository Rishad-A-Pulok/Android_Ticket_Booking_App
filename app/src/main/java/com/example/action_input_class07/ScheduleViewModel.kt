package com.example.action_input_class07

import android.util.Log
import androidx.lifecycle.ViewModel

class ScheduleViewModel: ViewModel() {

    fun addSchedule(schedule: BusSchedule){
        scheduleList.add(schedule)
    }
    fun getSchedule() = scheduleList
}