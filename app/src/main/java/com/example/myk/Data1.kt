package com.example.myk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.myk.databinding.ActivityData1Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Data1 : AppCompatActivity() {

    private lateinit var binding: ActivityData1Binding
    private lateinit var database: DatabaseReference
    var radioGroup2: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var button: Button
        private var roomtv: TextView? = null

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityData1Binding.inflate(layoutInflater)
       setContentView(binding.root)

        val getResultIntent = intent.getIntExtra("Day",0)
        binding.dddtv.text = "$getResultIntent"

        val getResultIntent1 = intent.getIntExtra("Moth",0)
        binding.mmmtv.text = "$getResultIntent1"

        val getResultIntent2 = intent.getIntExtra("Year",0)
        binding.yyytv.text = "$getResultIntent2"

        roomtv = findViewById<TextView>(R.id.roomtextView)

        var intent = intent
        roomtv!!.text = intent.getStringExtra("room")

        binding.button2.setOnClickListener {

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
            Toast.makeText(applicationContext,result.toString(), Toast.LENGTH_SHORT).show()
        }

        radioGroup2 = findViewById(R.id.radioGroup2)
        button = findViewById(R.id.button2)

        button.setOnClickListener {
            val selectedOption: Int = radioGroup2!!.checkedRadioButtonId
            radioButton = findViewById(selectedOption)
            Toast.makeText(baseContext,radioButton.text,Toast.LENGTH_SHORT).show()
        }



        binding.button2.setOnClickListener {

            val selectedOption: Int = radioGroup2!!.checkedRadioButtonId
            radioButton = findViewById(selectedOption)


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


            val room = binding.roomtextView.text.toString()
            val gt = radioButton.text.toString()
            val ddd = binding.dddtv.text.toString()
            val mmm = binding.mmmtv.text.toString()
            val yyy = binding.yyytv.text.toString()
            val head = binding.editTextTextMultiLine.text.toString()
            val person = binding.editTextTextPersonName2.text.toString()
            val dpm = spinner.selectedItem.toString()
            val gi = result.toString()
            database = FirebaseDatabase.getInstance().getReference("Booking")
            val Save = Save(room,gt,ddd,mmm,yyy,head,person,dpm,gi)

            database.child(room).setValue(Save).addOnSuccessListener {

                binding.editTextTextMultiLine.text.clear()
                binding.editTextTextPersonName2.text.clear()




                Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()

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
        val intent = Intent(this, list::class.java)
        startActivity(intent)
    }
//        val secondActbutton2 = findViewById<Button>(R.id.button2)
//        secondActbutton2.setOnClickListener {
//            val intent = Intent(this, History::class.java)
//            startActivity(intent)
//        }
    }
}

