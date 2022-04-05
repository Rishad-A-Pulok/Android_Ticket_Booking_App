package com.example.action_input_class07

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.title = "Online Ticket Booking"
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#5EA5DD")))

    }
}