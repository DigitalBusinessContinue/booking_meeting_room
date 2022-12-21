package com.example.myk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Room : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var fill:Array<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val secondActImageView = findViewById<ImageView>(R.id.click1)
        secondActImageView.setOnClickListener {
            val intent = Intent(this, Data1::class.java)
            startActivity(intent)
        }

        imageId= arrayOf(
            R.drawable._1,
            R.drawable._2,
            R.drawable._3,
            R.drawable._4,
            R.drawable._5

        )
        heading= arrayOf(
            "ห้องประชุม 1",
            "ห้องประชุม 2",
            "ห้องประชุม 3",
            "ห้องประชุม 4",
            "ห้องประชุม 5"

        )
        fill= arrayOf(
            "บรรจุได้ 10 คน",
            "บรรจุได้ 6 คน",
            "บรรจุได้ 11 คน",
            "บรรจุได้ 4 คน",
            "บรรจุได้ 50 คน"

        )
        newRecyclerView=findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<News>()

        getUserData()
    }
    private fun getUserData(){
        for (i in imageId.indices){
            val news =News(imageId[i],heading[i],fill[i])
            newArrayList.add(news)
        }

        newRecyclerView.adapter=MyAdapter(newArrayList)
            }

        }



