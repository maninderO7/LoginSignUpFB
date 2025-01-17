package com.o7.loginsignupfb

import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val email = intent.getStringExtra("email")
        val pass = intent.getStringExtra("pass")


        val tvShowMail = findViewById<TextView>(R.id.tvShowMail)
        val tvShowPass = findViewById<TextView>(R.id.tvShowPass)

        tvShowPass.text = tvShowPass.text.toString() + pass
        tvShowMail.text = tvShowMail.text.toString() + email
//
//        if(intent.getStringExtra("id")=="signup"){
//
//            val name = intent.getStringExtra("name")
//            val tvShowName = findViewById<TextView>(R.id.tvShowName)
//
//            tvShowName.text = "Name - " + name
//
//
//        }


    }
}