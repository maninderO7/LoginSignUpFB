package com.o7.loginsignupfb

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val tvSignIn = findViewById<TextView>(R.id.tvSignIn)

        val spannableString1 = SpannableString(tvSignIn.text.toString())
        spannableString1.setSpan(UnderlineSpan(),0, spannableString1.length, 0)
        tvSignIn.text = spannableString1


        val edtLoginName = findViewById<EditText>(R.id.edtLoginName)

        val edtLoginInPass = findViewById<TextInputEditText>(R.id.edtLoginPass)

        val btnSignIn = findViewById<Button>(R.id.btnSignIn)

        btnSignIn.setOnClickListener {
            var okay: Boolean = true
            if(edtLoginInPass.editableText.toString().isEmpty()){
                okay = false
                edtLoginInPass.error = "No Password Entered"
            }

            if(edtLoginName.text.isEmpty()){
                okay = false
                edtLoginName.error = "No Username Given"
            }

            if(okay){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", "login")
                intent.putExtra("email", edtLoginName.text.toString().trim())
                intent.putExtra("pass", edtLoginInPass.editableText.toString().trim())
                startActivity(intent)
                finish()

            }


        }

       // edtpass.transformationMethod = PasswordTransformationMethod.getInstance()

        val tvSignUpPage = findViewById<TextView>(R.id.tvSignUp)

        tvSignUpPage.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)

            startActivity(intent)
            finish()

        }

    }
}