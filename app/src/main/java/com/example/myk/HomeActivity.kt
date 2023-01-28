package com.example.myk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.Toast
import com.example.myk.databinding.ActivityHomeBinding
import com.example.myk.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.Calendar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var user: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = FirebaseAuth.getInstance()

        if (user.currentUser != null){
            user.currentUser?.let {

                binding.useremail.text = it.email
            }
        }

        binding.btlogout.setOnClickListener{
            user.signOut()
            startActivity(
                Intent(this,MainActivity::class.java)
            )
            finish()
        }


        val picker = findViewById<DatePicker>(R.id.datePicker)
        val today = Calendar.getInstance()
        picker.init(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH)){
            view, year, moth, day ->
            val  month = moth+1
            val intent = Intent(this,list::class.java)
                startActivity(intent)
        }
        val secondActbutton = findViewById<Button>(R.id.button7)
        secondActbutton.setOnClickListener {
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }
    }


}
