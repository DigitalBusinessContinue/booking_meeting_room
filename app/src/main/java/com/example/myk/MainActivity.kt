package com.example.myk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val secondActbutton = findViewById<Button>(R.id.loginbutton)
       secondActbutton.setOnClickListener {
          val intent = Intent(this, HomeActivity::class.java)
       startActivity(intent)
        }

    }
}