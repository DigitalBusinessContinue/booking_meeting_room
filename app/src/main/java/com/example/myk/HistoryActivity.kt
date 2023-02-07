package com.example.myk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class HistoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var usersArrayList: ArrayList<Save>
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        recyclerView = findViewById(R.id.rc)
        recyclerView.layoutManager = LinearLayoutManager(this)

        usersArrayList = arrayListOf()

        database = FirebaseDatabase.getInstance().getReference("Booking")
        database.addValueEventListener(object :ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapShot in snapshot.children) {
                        val user = dataSnapShot.getValue(Save::class.java)
                        if (!usersArrayList.contains(user)){
                            usersArrayList.add(user!!)
                    }
                }
                    recyclerView.adapter = Adapter(usersArrayList)
            }
        }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@HistoryActivity,error.toString(),Toast.LENGTH_SHORT).show()
            }
        })


    val secondActbutton = findViewById<Button>(R.id.button66)
    secondActbutton.setOnClickListener {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    }
}