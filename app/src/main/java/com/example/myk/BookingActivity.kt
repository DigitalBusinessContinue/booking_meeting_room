package com.example.myk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.myk.databinding.ActivityBookingBinding
import com.google.firebase.database.*
import java.util.*
import kotlin.concurrent.schedule

class BookingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookingBinding
    private lateinit var database: DatabaseReference
    private var roomtv: TextView? = null
    private var listHistory = mutableListOf<Save>()

    private var date =""
    private var room =""

    @SuppressLint("MissingInflatedId", "CutPasteId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getHistory()

         date = intent.getStringExtra("KEY_DATE") ?: ""
        binding.dateTextView.text = date

        room = intent.getStringExtra("room").toString()
        binding.roomtextView.text = room


        roomtv = findViewById<TextView>(R.id.roomtextView)

        var intent = intent
        roomtv?.text = intent.getStringExtra("room")


        binding.saveButton.setOnClickListener {
            var textTost = "Save."
            Toast.makeText(baseContext,textTost,Toast.LENGTH_SHORT).show()

            var totalAmount1: Int = 0
            var result1 = StringBuilder()

            if (binding.morningCheckbox.isChecked){
                result1.append("\n08:00-12:00น.")
                totalAmount1+=1
            }
            if (binding.afternoonCheckbox.isChecked){
                result1.append("\n13:00-18:00น.")
                totalAmount1+=1
            }

            result1.append("\n")

            var totalAmount: Int = 0
            var result = StringBuilder()

            if (binding.checkBox1.isChecked){
                result.append("\nคอมพิวเตอร์")
                totalAmount+=1
            }
            if (binding.checkBox2.isChecked){
                result.append("\nเลเซอร์พอยเตอร์")
                totalAmount+=1
            }
            if (binding.checkBox3.isChecked){
                result.append("\nไมโครโฟน")
                totalAmount+=1
            }

            result.append("\n")

            val players = arrayOf("HR Admin","Engineering","QA QC","Production","IT","Marketing","Factory Support","Project","Welding","Accounting","Construction")
            val spinner = findViewById<Spinner>(R.id.spinner1)
            val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,players)
            spinner.adapter = arrayAdapter

            // Book time

            var isMorning = binding.morningCheckbox.isChecked
            var isAfternoon = binding.afternoonCheckbox.isChecked

            val room = binding.roomtextView.text.toString()
            val head = binding.editTextTextMultiLine.text.toString().trim()
            val person = binding.editTextTextPersonName2.text.toString().trim()
            val dpm = spinner.selectedItem.toString().trim()
            val gi = result.toString().trim()
            val itime = result1.toString().trim()

            if (TextUtils.isEmpty(head)){
                binding.editTextTextMultiLine.error = "กรุณากรอกข้อมูล"
            }
            if (TextUtils.isEmpty(person)){
                binding.editTextTextPersonName2.error = "กรุณากรอกข้อมูล"
            }
            else{
                var database = FirebaseDatabase.getInstance()
                var databaseReference = database.reference.child("Booking")
                var id = databaseReference.push()

                id.child("id").setValue(id.key.toString())
                id.child("aroom").setValue(room)
                id.child("ismorning").setValue(isMorning)
                id.child("isafternoon").setValue(isAfternoon)
                id.child("date").setValue(date)
                id.child("fhead").setValue(head)
                id.child("gperson").setValue(person)
                id.child("hdepertment").setValue(dpm)
                id.child("iitem").setValue(gi)
                id.child("itime").setValue(itime)
           // }
            //database = FirebaseDatabase.getInstance().getReference("Booking")
            //val Save = Save(room,gt,ddd,mmm,yyy,head,person,dpm,gi)

          // database.child(room).setValue(Save).addOnSuccessListener {

//                binding.editTextTextMultiLine.text.clear()
//                binding.editTextTextPersonName2.text.clear()
                Toast.makeText(applicationContext,"Save",Toast.LENGTH_SHORT).show()
                //Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
               val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)

          }
        }



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
                Toast.makeText(applicationContext,"selected player is = "+players[p2],Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            }
    val secondActbutton = findViewById<Button>(R.id.button5)
    secondActbutton.setOnClickListener {
        val intent = Intent(this, ListActivity::class.java)
        intent.putExtra("KEY_DATE",date)
        startActivity(intent)
    }

    }

    private fun getHistory(){

        database = FirebaseDatabase.getInstance().getReference("Booking")
        database.addListenerForSingleValueEvent(object :ValueEventListener {

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
                Toast.makeText(this@BookingActivity,error.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        checkBookingTime()
    }

    @SuppressLint("ResourceAsColor")
    private fun checkBookingTime(){
        val a = listHistory.size
        Timer().schedule(3000){
            listHistory.filter { listHistory ->
                listHistory.date == date && listHistory.aroom == room
            }.forEach { history ->
                when{
                    history?.ismorning == true ->{
                        //binding.morningCheckbox.isChecked = history?.ismorning == true
                        binding.morningCheckbox.setBackgroundResource(android.R.color.holo_red_dark)
                        binding.morningCheckbox.setTextColor(R.color.grey)
                    }
                    history?.isafternoon == true ->{
                        //binding.afternoonCheckbox.isChecked = history?.isafternoon == true
                        binding.afternoonCheckbox.setBackgroundResource(android.R.color.holo_red_dark)
                        binding.afternoonCheckbox.setTextColor(R.color.grey)

                    }
                }
            }
        }
    }
}

