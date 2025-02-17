package com.example.ukk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {

    private EditText Title, Author, Year, gff;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        Title = findViewById(R.id.Title);
        Author = findViewById(R.id.Author);
        Year = findViewById(R.id.Year);
        gff = findViewById(R.id.gff);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String title = Title.getText().toString();
            String author = Author.getText().toString();
            String year = Year.getText().toString();
            String gff ;

            // Simpan data buku ke database atau list
            Toast.makeText(AddBookActivity.this, "Book added successfully!", Toast.LENGTH_SHORT).show();
        });
    }
}
