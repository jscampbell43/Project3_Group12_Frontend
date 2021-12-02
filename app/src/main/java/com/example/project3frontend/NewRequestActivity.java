package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewRequestActivity extends AppCompatActivity {
    // Layout pieces
    private Button buttonBackToProfile;
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
        buttonBackToProfile = findViewById(R.id.buttonBackToProfile);

        // Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        buttonBackToProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(NewRequestActivity.this, LandingActivity.class);
                startActivity(intent);
            }
        });

        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getText().toString();
                String image = editTextImage.getText().toString();
                // If title is blank
                if(title.isEmpty()) {
                    Toast.makeText(NewRequestActivity.this, "A title is required", Toast.LENGTH_SHORT).show();
                }else{
                    //TO DO call API to add new request information to database
                    Toast.makeText(NewRequestActivity.this, "The following Info will be added to database here:\n" + title + "\n" + description + "\n" +  image + "\n", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}