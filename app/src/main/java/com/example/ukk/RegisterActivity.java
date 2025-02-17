package com.example.ukk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerUsername, registerPassword;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUsername = findViewById(R.id.registerUsername);
        registerPassword = findViewById(R.id.registerPassword);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(v -> {
            String username = registerUsername.getText().toString();
            String password = registerPassword.getText().toString();

            // Proses pendaftaran
            // Biasanya akan dihubungkan dengan database untuk menyimpan data pengguna baru
            Toast.makeText(RegisterActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
