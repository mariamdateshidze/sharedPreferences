package com.example.save

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }
    private fun init(){
        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)

        val email = sharedPreferences.getString("email", "")
        val firstName = sharedPreferences.getString("firstName", "")
        val lastName = sharedPreferences.getString("lastName", "")
        val age = sharedPreferences.getString("age", "")
        val address = sharedPreferences.getString("address", "")


        emailED.setText(email)
        firstNameED.setText(firstName)
        lastNameED.setText(lastName)
        ageED.setText(age.toString())
        addressED.setText(address)

    }


    fun save(view:View){
        val email = emailED.text.toString()
        val firstName = firstNameED.text.toString()
        val lastName = lastNameED.text.toString()
        val age = ageED.text.toString()
        val address = addressED.text.toString()

        if(email.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && address.isNotEmpty() &&age.isNotEmpty()){
            val editor = sharedPreferences.edit()
            editor.putString("email", email)
            editor.putString("firstName", firstName)
            editor.putString("lastName", lastName)
            editor.putString("address", address)
            editor.putString("age", age)
            editor.apply()

            Toast.makeText(applicationContext,"data saved successfully", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext,"fill all fields", Toast.LENGTH_SHORT).show()
        }

        }

    }
