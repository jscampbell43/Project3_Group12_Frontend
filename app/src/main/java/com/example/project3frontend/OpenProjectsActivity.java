package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OpenProjectsActivity extends AppCompatActivity {

    // Layout pieces
    private Button buttonBackToProfile;
    private TextView textViewOpenProjectsWelcome;
    private EditText editTextSearchProject;
    private Button buttonSearchProject;
    private static final String TAG = "NewRequestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_projects);

        // Attach layout
        textViewOpenProjectsWelcome = findViewById(R.id.textViewOpenProjectsWelcome);
        editTextSearchProject = findViewById(R.id.editTextSearchProject);
        buttonSearchProject = findViewById(R.id.buttonSearchProject);
        buttonBackToProfile = findViewById(R.id.buttonBackToProfile);

        // Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        buttonBackToProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(OpenProjectsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}