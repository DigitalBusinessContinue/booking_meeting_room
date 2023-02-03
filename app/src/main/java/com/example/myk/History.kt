package com.example.myk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class History : AppCompatActivity() {

//    lateinit var mRecyclerView: RecyclerView
//    lateinit var mDatabase : DatabaseReference
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
                Toast.makeText(this@History,error.toString(),Toast.LENGTH_SHORT).show()
            }
        })

//        mDatabase = FirebaseDatabase.getInstance().getReference("Booking")
//        mRecyclerView = findViewById(R.id.rc)
//
//        logRecyclerView()
//
////        replaceFragment(Hindd())
//
//
//
//
////    val secondActbutton = findViewById<Button>(R.id.button66)
////    secondActbutton.setOnClickListener {
////        val intent = Intent(this, HomeActivity::class.java)
////        startActivity(intent)
////    }
//}
//
//    private fun logRecyclerView() {
//        var FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<Bk ,BookingViewHolder>(
//
//            Bk::class.java,
//            R.layout.item_layout,
//            BookingViewHolder::class.java,
//            mDatabase
//        ){
//            fun populateViewHolder(viewHolder: BookingViewHolder?, model: Bk?, position: Int){
//
//            }
//
//        }
//    }
//
//    class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frame_layout,fragment)
//        fragmentTransaction.commit()
//
    }
}