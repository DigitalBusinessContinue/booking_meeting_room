package com.example.myk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.myk.Adapter.MyAdapter

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val secondActbutton = findViewById<Button>(R.id.button3)
        secondActbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val secondActbutton1 = findViewById<Button>(R.id.button5)
        secondActbutton1.setOnClickListener {
            val intent = Intent(this, Data1::class.java)
            startActivity(intent)
        }
        val secondActbutton2 = findViewById<Button>(R.id.button6)
        secondActbutton2.setOnClickListener {
            val intent = Intent(this, MyAdapter::class.java)
            startActivity(intent)
        }
        val secondActbutton3 = findViewById<Button>(R.id.button7)
        secondActbutton3.setOnClickListener {
            val intent = Intent(this, Data3::class.java)
            startActivity(intent)
        }
        val secondActbutton4 = findViewById<Button>(R.id.button8)
        secondActbutton4.setOnClickListener {
            val intent = Intent(this, Data4::class.java)
            startActivity(intent)
        }
        val secondActbutton5 = findViewById<Button>(R.id.button9)
        secondActbutton5.setOnClickListener {
            val intent = Intent(this, Data5::class.java)
            startActivity(intent)
        }
    }
}
