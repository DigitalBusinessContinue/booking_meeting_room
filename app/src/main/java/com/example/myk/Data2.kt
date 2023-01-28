package com.example.myk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.*
import androidx.viewpager.widget.ViewPager

import com.google.android.material.tabs.TabLayout

class Data2 : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data2)

        val players = arrayOf("HR Admin","Engineering","QA QC","Production","IT","Marketing","Factory Support","Project","Welding","Accounting","Construction")
        val spinner = findViewById<Spinner>(R.id.spinner1)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,players)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                Toast.makeText(applicationContext,"selected player is = "+players[p2], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val secondActbutton = findViewById<Button>(R.id.button5)
        secondActbutton.setOnClickListener {
            val intent = Intent(this, list::class.java)
            startActivity(intent)
        }
        val secondActbutton2 = findViewById<Button>(R.id.button2)
        secondActbutton2.setOnClickListener {
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }

    }
}