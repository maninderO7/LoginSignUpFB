package com.o7.loginsignupfb

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
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

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvSignUp = this.findViewById<TextView>(R.id.tvSignUp)

        val spannableString1 = SpannableString(tvSignUp.text.toString())
        spannableString1.setSpan(UnderlineSpan(),0, spannableString1.length, 0)
        tvSignUp.text = spannableString1

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtPass = findViewById<TextInputEditText>(R.id.edtPass)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtConfirmPass = findViewById<TextInputEditText>(R.id.edtConfirmPass)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            var okay: Boolean = true
            if(edtPass.editableText.isEmpty()){
                okay = false
                edtPass.error = "No Password Entered"
            }

            if(edtName.text.isEmpty()){
                okay = false
                edtName.error = "No Username Given"
            }

            if(edtEmail.text.isEmpty()){
                okay = false
                edtEmail.error = "No email id entered"
            }

            if(edtConfirmPass.editableText.isEmpty()){
                okay = false
                edtConfirmPass.error = "please re-enter your password"
            }else if(edtConfirmPass.editableText.toString().compareTo(edtPass.editableText.toString()) != 0){
                okay = false
                edtConfirmPass.error = "Confirm Password Failed"
            }

            if(okay){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", "signup")
                intent.putExtra("name", edtName.text.toString().trim())
                intent.putExtra("pass", edtPass.editableText.toString().trim())
                intent.putExtra("email", edtEmail.text.toString().trim())
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