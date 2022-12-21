package com.example.myk

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Room : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

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
        newRecyclerView=findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<News>()

        getUserData()
    }
    private fun getUserData(){
        for (i in imageId.indices){
            val news =News(imageId[i],heading[i])
            newArrayList.add(news)
        }
        newRecyclerView.adapter=MyAdapter(newArrayList)
    }

}
