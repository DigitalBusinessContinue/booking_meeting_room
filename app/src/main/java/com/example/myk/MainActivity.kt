package com.example.myk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.myk.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var user: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user = FirebaseAuth.getInstance()

        checkIfUserIsLooed()

        binding.loginbutton.setOnClickListener {
            registerUser()
        }

    }

    private fun  checkIfUserIsLooed(){

        if (user.currentUser !=null){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
    }

    private fun registerUser() {

        val email = binding.editTextTextPersonName5.text.toString()
        val password = binding.editTextTextPersonName6.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {

            user.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity()) { task ->

                    if (task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "User added successfully",
                            Toast.LENGTH_SHORT
                        ).show()

                        startActivity(Intent(this, HomeActivity::class.java))
                        finish()
                    } else {
                        user.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener{mTask->
                                if (mTask.isSuccessful){
                                    startActivity(Intent(this, HomeActivity::class.java))
                                    finish()
                                }else{

                                    Toast.makeText(
                                        this,
                                        task.exception!!.message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }

                }

        } else {
            Toast.makeText(
                this,
                "Email and password cannot be empty",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
