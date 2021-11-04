package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewRequestActivity extends AppCompatActivity {
    // Layout pieces
    private TextView textViewNewRequestWelcome;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextImage;
    private Button buttonPublish;
    private static final String TAG = "NewRequestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);

        // Attach layout
        textViewNewRequestWelcome = findViewById(R.id.textViewNewRequestWelcome);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextImage = findViewById(R.id.editTextImage);
        buttonPublish = findViewById(R.id.buttonPublish);
    }
}