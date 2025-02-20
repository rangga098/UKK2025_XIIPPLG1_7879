package com.example.ukk

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var userNameTextView: TextView
    private lateinit var userEmailTextView: TextView
    private lateinit var userProfileImageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        // Inisialisasi komponen UI
        userNameTextView = findViewById(R.id.textView)
        userEmailTextView = findViewById(R.id.textView)
        userProfileImageView = findViewById(R.id.imageView2)

        // Ambil data pengguna (misalnya, dari SharedPreferences atau database)
        val userName = "Nama Pengguna"  // Ganti dengan data nyata
        val userEmail = "user@domain.com"  // Ganti dengan data nyata

        // Menampilkan informasi pengguna
        userNameTextView.text = userName
        userEmailTextView.text = userEmail

        // Misalnya, menampilkan gambar profil (dapat menggunakan Glide atau Picasso untuk memuat gambar)
        // Glide.with(this).load(imageUrl).into(userProfileImageView)
    }
}