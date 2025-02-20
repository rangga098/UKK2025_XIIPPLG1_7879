package com.example.ukk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.registerNama)
        val email = findViewById<EditText>(R.id.registerUsername)
        val password = findViewById<EditText>(R.id.registerPassword)
        val KonfirmasiPassword = findViewById<EditText>(R.id.registerKonfirmasiPassword)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val kembali = findViewById<Button>(R.id.kembali)


        registerButton.setOnClickListener {
            val enteredName = name.text.toString()
            val enteredEmail = email.text.toString()
            val enteredPassword = password.text.toString()
            val KonfirmasiPassword = KonfirmasiPassword.text.toString()

            // Save user data in SharedPreferences
            val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("name", enteredName)
                putString("email", enteredEmail)
                putString("password", enteredPassword)
                apply()
            }

            // Redirect to login
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}