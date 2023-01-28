package com.example.myk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class list : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val secondActImageView = findViewById<ImageView>(R.id.click1)
        secondActImageView.setOnClickListener {
            val intent = Intent(this, Data1::class.java)
            startActivity(intent)
        }
        val secondActImageView1 = findViewById<ImageView>(R.id.click2)
        secondActImageView1.setOnClickListener {
            val intent = Intent(this, Data2::class.java)
            startActivity(intent)
        }
        val secondActImageView2 = findViewById<ImageView>(R.id.click3)
        secondActImageView2.setOnClickListener {
            val intent = Intent(this, Data3::class.java)
            startActivity(intent)
        }
        val secondActImageView3 = findViewById<ImageView>(R.id.click4)
        secondActImageView3.setOnClickListener {
            val intent = Intent(this, Data4::class.java)
            startActivity(intent)
        }
        val secondActImageView4 = findViewById<ImageView>(R.id.click5)
        secondActImageView4.setOnClickListener {
            val intent = Intent(this, Data5::class.java)
            startActivity(intent)
        }
        val secondActbutton = findViewById<Button>(R.id.button55)
        secondActbutton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}