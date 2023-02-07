package com.example.myk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.myk.databinding.ActivityListBinding
import com.google.firebase.database.*
import java.util.*
import kotlin.concurrent.schedule

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var database: DatabaseReference
    private var listHistory = mutableListOf<Save>()
    private var date : String =""
    private var room : String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
      getHistory()

         date = intent.getStringExtra("KEY_DATE") ?: ""
        binding.dateTextView.text = date
//
//        room = intent.getStringExtra("room") ?: ""
//        binding.r1.text = "ห้องประชุม 1"
//
//        room = intent.getStringExtra("room") ?: ""
//        binding.r2.text = "ห้องประชุม 2"


        val secondActImageView = findViewById<ImageView>(R.id.click1)
        secondActImageView.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("room","ห้องประชุม 1")
            intent.putExtra("KEY_DATE",date)
            startActivity(intent)
        }
        val secondActImageView1 = findViewById<ImageView>(R.id.click2)
        secondActImageView1.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("room","ห้องประชุม 2")
            intent.putExtra("KEY_DATE",date)
            startActivity(intent)
        }
        val secondActImageView2 = findViewById<ImageView>(R.id.click3)
        secondActImageView2.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("room","ห้องประชุม 3")
            intent.putExtra("KEY_DATE",date)
            startActivity(intent)
        }
        val secondActImageView3 = findViewById<ImageView>(R.id.click4)
        secondActImageView3.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("room","ห้องประชุม 4")
            intent.putExtra("KEY_DATE",date)
            startActivity(intent)
        }
        val secondActImageView4 = findViewById<ImageView>(R.id.click5)
        secondActImageView4.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("room","ห้องประชุม 5")
            intent.putExtra("KEY_DATE",date)
            startActivity(intent)
        }
        val secondActbutton = findViewById<Button>(R.id.button55)
        secondActbutton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getHistory() {
        database = FirebaseDatabase.getInstance().getReference("Booking")
        database.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapShot in snapshot.children) {
                        dataSnapShot.getValue(Save::class.java)?.let{ _history ->
                            listHistory.add(_history)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ListActivity,error.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        checkBookingTime1()
        checkBookingTime2()
        checkBookingTime3()
        checkBookingTime4()
        checkBookingTime5()


    }

    private fun checkBookingTime1(){
        val a = listHistory.size
        Timer().schedule(3000){
            listHistory.filter { listHistory ->
                listHistory.date == date && listHistory.aroom == "ห้องประชุม 1"
            }.forEach { history ->
                when{
                    history?.ismorning == true ->{
                        binding.textView11.setBackgroundResource(android.R.color.holo_red_dark)
                    }
                    history?.isafternoon == true ->{
                        binding.textView111.setBackgroundResource(android.R.color.holo_red_dark)

                    }
                }
            }
        }
    }
    private fun checkBookingTime2(){
        val a = listHistory.size
        Timer().schedule(3000){
            listHistory.filter { listHistory ->
                listHistory.date == date && listHistory.aroom == "ห้องประชุม 2"
            }.forEach { history ->
                when{
                    history?.ismorning == true ->{
                        binding.textView22.setBackgroundResource(android.R.color.holo_red_dark)
                    }
                    history?.isafternoon == true ->{
                        binding.textView222.setBackgroundResource(android.R.color.holo_red_dark)

                    }
                }
            }
        }
    }
    private fun checkBookingTime3(){
        val a = listHistory.size
        Timer().schedule(3000){
            listHistory.filter { listHistory ->
                listHistory.date == date && listHistory.aroom == "ห้องประชุม 3"
            }.forEach { history ->
                when{
                    history?.ismorning == true ->{
                        binding.textView33.setBackgroundResource(android.R.color.holo_red_dark)
                    }
                    history?.isafternoon == true ->{
                        binding.textView333.setBackgroundResource(android.R.color.holo_red_dark)

                    }
                }
            }
        }
    }
    private fun checkBookingTime4(){
        val a = listHistory.size
        Timer().schedule(3000){
            listHistory.filter { listHistory ->
                listHistory.date == date && listHistory.aroom == "ห้องประชุม 4"
            }.forEach { history ->
                when{
                    history?.ismorning == true ->{
                        binding.textView44.setBackgroundResource(android.R.color.holo_red_dark)
                    }
                    history?.isafternoon == true ->{
                        binding.textView444.setBackgroundResource(android.R.color.holo_red_dark)

                    }
                }
            }
        }
    }
    private fun checkBookingTime5(){
        val a = listHistory.size
        Timer().schedule(3000){
            listHistory.filter { listHistory ->
                listHistory.date == date && listHistory.aroom == "ห้องประชุม 5"
            }.forEach { history ->
                when{
                    history?.ismorning == true ->{
                        binding.textView55.setBackgroundResource(android.R.color.holo_red_dark)
                    }
                    history?.isafternoon == true ->{
                        binding.textView555.setBackgroundResource(android.R.color.holo_red_dark)

                    }
                }
            }
        }
    }
//
//    private fun checkBookingTime2(){
//        val a = listHistory.size
//        Timer().schedule(3000){
//            listHistory.filter { listHistory ->
//                listHistory.date == date &&
//                        listHistory.aroom == "ห้องประชุม 2"
//            }.forEach { history ->
//                when{
//                    history?.ismorning == true ->{
//                        binding.textView22.setBackgroundResource(android.R.color.holo_red_dark)
//                    }
//                    history?.isafternoon == true ->{
//                        binding.textView222.setBackgroundResource(android.R.color.holo_red_dark)
//
//                    }
//                }
//            }
//        }
//    }
//    private fun checkBookingTime3(){
//        val a = listHistory.size
//        Timer().schedule(3000){
//            listHistory.filter { listHistory ->
//                listHistory.date == date &&
//                        listHistory.aroom == "ห้องประชุม 2"
//            }.forEach { history ->
//                when{
//                    history?.ismorning == true ->{
//                        binding.textView22.setBackgroundResource(android.R.color.holo_red_dark)
//                    }
//                    history?.isafternoon == true ->{
//                        binding.textView222.setBackgroundResource(android.R.color.holo_red_dark)
//
//                    }
//                }
//            }
//        }
//    }

    }
