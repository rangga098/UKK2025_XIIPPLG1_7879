package com.example.ukk

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditTask : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var categorySpinner: Spinner
    private lateinit var saveButton: Button
    private lateinit var descriptionEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var timeEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        dbHelper = DatabaseHelper(this)

        // Inisialisasi UI
        descriptionEditText = findViewById(R.id.descriptionEditText)
        dateEditText = findViewById(R.id.dateEditText)
        timeEditText = findViewById(R.id.timeEditText)
        categorySpinner = findViewById(R.id.categorySpinner)
        saveButton = findViewById(R.id.saveTaskButton)

        // Menyiapkan kategori spinner
        val categories = arrayOf("Pekerjaan", "Pribadi", "Olahraga", "Belajar")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        // Menangani klik tombol simpan
        saveButton.setOnClickListener {
            val description = descriptionEditText.text.toString()
            val date = dateEditText.text.toString()
            val time = timeEditText.text.toString()
            val category = categorySpinner.selectedItem.toString()

            if (description.isEmpty() || date.isEmpty() || time.isEmpty()) {
                Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Membuat objek tugas baru
            val newTask = Task(
                id = 0,  // ID di-set 0 untuk task baru
                description = description,
                date = date,
                time = time,
                category = category,
                isCompleted = false,  // Status tugas belum selesai
                isHistory = false // Set ke false karena tugas baru bukan bagian dari histori
            )

            // Menyimpan tugas ke database
            dbHelper.addTask(newTask)

            // Menampilkan pesan sukses
            Toast.makeText(this, "Tugas berhasil dibuat!", Toast.LENGTH_SHORT).show()

            // Menutup activity setelah penyimpanan
            finish()
        }
    }
}