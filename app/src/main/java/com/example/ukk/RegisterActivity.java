package com.example.ukk;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerNama, registerUsername, registerPassword, registerKonfirmasiPassword;
    private Button registerButton, kembali;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerNama = findViewById(R.id.registerNama);
        registerUsername = findViewById(R.id.registerUsername);
        registerPassword = findViewById(R.id.registerPassword);
        registerKonfirmasiPassword = findViewById(R.id.registerKonfirmasiPassword);
        registerButton = findViewById(R.id.registerButton);
        kembali = findViewById(R.id.kembali);

        registerButton.setOnClickListener(v -> {
            String Nama= registerNama.getText().toString();
            String username = registerUsername.getText().toString();
            String password = registerPassword.getText().toString();
            String KonfirmasiPassword = registerKonfirmasiPassword.getText().toString();

            // Proses pendaftaran
            // Biasanya akan dihubungkan dengan database untuk menyimpan data pengguna baru
            Toast.makeText(RegisterActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
