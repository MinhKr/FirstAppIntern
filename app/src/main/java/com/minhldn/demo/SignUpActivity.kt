package com.minhldn.demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    private lateinit var edtFirstName: EditText
    private lateinit var edtLastName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnCreateAccount: androidx.appcompat.widget.AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtFirstName = findViewById(R.id.edt_first_name)
        edtLastName = findViewById(R.id.edt_last_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnCreateAccount = findViewById(R.id.btn_createAccount)

        btnCreateAccount.setOnClickListener {
            validate()
        }
    }

    fun validate() {
        val edtFirstName = edtFirstName.text.toString().trim()
        val edtLastName = edtLastName.text.toString().trim()
        val edtEmail = edtEmail.text.toString().trim()
        val edtPassword = edtPassword.text.toString().trim()

        when {
            edtFirstName.isEmpty() -> Toast.makeText(
                this,
                "First name must be not empty",
                Toast.LENGTH_SHORT
            ).show()

            edtLastName.isEmpty() -> Toast.makeText(
                this,
                "Last name must be not empty",
                Toast.LENGTH_SHORT
            ).show()

            !Patterns.EMAIL_ADDRESS.matcher(edtEmail).matches() -> Toast.makeText(
                this,
                "Email must be valid",
                Toast.LENGTH_SHORT
            ).show()

            edtPassword.isEmpty() -> Toast.makeText(
                this,
                "Password must be not empty",
                Toast.LENGTH_SHORT
            ).show()

            else -> {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("email", edtEmail)
                    startActivity(this)
                }
            }
        }

    }
}