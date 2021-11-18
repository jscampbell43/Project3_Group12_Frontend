package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Layout pieces
    private TextView textViewProfileWelcome;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach layout
        textViewProfileWelcome = findViewById(R.id.textViewProfileWelcome);

        // Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

    }
}