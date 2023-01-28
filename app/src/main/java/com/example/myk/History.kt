package com.example.myk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class History : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

    val secondActbutton = findViewById<Button>(R.id.button66)
    secondActbutton.setOnClickListener {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
}