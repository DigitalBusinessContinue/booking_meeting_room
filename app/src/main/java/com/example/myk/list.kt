package com.example.myk

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import com.example.myk.back.section
import com.example.myk.databinding.ActivityListBinding
import java.util.Calendar

class list : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getResultIntent = intent.getIntExtra("Day",0)
        binding.datetextView1.text = "$getResultIntent"

        val getResultIntent1 = intent.getIntExtra("Month",0)
        binding.datetextView2.text = "$getResultIntent1"

        val getResultIntent2 = intent.getIntExtra("Year",0)
        binding.datetextView3.text = "$getResultIntent2"


        val secondActImageView = findViewById<ImageView>(R.id.click1)
        secondActImageView.setOnClickListener {
            val intent = Intent(this, Data1::class.java)
            intent.putExtra("room","ห้องประชุม 1")
            intent.putExtra("Day",getResultIntent)
            intent.putExtra("Moth",getResultIntent1)
            intent.putExtra("Year",getResultIntent2)
            startActivity(intent)
        }
        val secondActImageView1 = findViewById<ImageView>(R.id.click2)
        secondActImageView1.setOnClickListener {
            val intent = Intent(this, Data1::class.java)
            intent.putExtra("room","ห้องประชุม 2")
            intent.putExtra("Day",getResultIntent)
            intent.putExtra("Moth",getResultIntent1)
            intent.putExtra("Year",getResultIntent2)
            startActivity(intent)
        }
        val secondActImageView2 = findViewById<ImageView>(R.id.click3)
        secondActImageView2.setOnClickListener {
            val intent = Intent(this, Data1::class.java)
            intent.putExtra("room","ห้องประชุม 3")
            intent.putExtra("Day",getResultIntent)
            intent.putExtra("Moth",getResultIntent1)
            intent.putExtra("Year",getResultIntent2)
            startActivity(intent)
        }
        val secondActImageView3 = findViewById<ImageView>(R.id.click4)
        secondActImageView3.setOnClickListener {
            val intent = Intent(this, Data1::class.java)
            intent.putExtra("room","ห้องประชุม 4")
            intent.putExtra("Day",getResultIntent)
            intent.putExtra("Moth",getResultIntent1)
            intent.putExtra("Year",getResultIntent2)
            startActivity(intent)
        }
        val secondActImageView4 = findViewById<ImageView>(R.id.click5)
        secondActImageView4.setOnClickListener {
            val intent = Intent(this, Data1::class.java)
            intent.putExtra("room","ห้องประชุม 5")
            intent.putExtra("Day",getResultIntent)
            intent.putExtra("Moth",getResultIntent1)
            intent.putExtra("Year",getResultIntent2)
            startActivity(intent)
        }
        val secondActbutton = findViewById<Button>(R.id.button55)
        secondActbutton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}