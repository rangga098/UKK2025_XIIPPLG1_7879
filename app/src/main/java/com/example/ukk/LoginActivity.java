package com.example.ukk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton;
    private TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        registerLink = findViewById(R.id.registerLink);

        loginButton.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(validateLogin(user, pass)) {
                // Ganti Activity berdasarkan tipe user (admin atau user biasa)
                if(user.equals("admin")) {
                    startActivity(new Intent(LoginActivity.this, AdminDashboard.class));
                } else {
                    startActivity(new Intent(LoginActivity.this, UserDashboard.class));
                }
            } else {
                Toast.makeText(LoginActivity.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
            }
        });

        registerLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, com.example.ukk.RegisterActivity.class));
        });
    }

    private boolean validateLogin(String username, String password) {
        // Validasi login sederhana (bisa diganti dengan database)
        return username.equals("admin") && password.equals("admin123");
    }
}

