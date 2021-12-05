package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OpenProjectDetailsActivity extends AppCompatActivity {

    ImageView projectImageView;
    TextView projectTitle;
    TextView projectDescription;

    Bundle extras;
    String title, description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_project_details);

        projectImageView = findViewById(R.id.imageViewProjectImageDetails);
        projectTitle = findViewById(R.id.textViewProjectTitleDetails);
        projectDescription = findViewById(R.id.textViewProjectDescriptionDetails);

        getData();
        setData();

    }

    private void getData(){
        extras = getIntent().getExtras();
        // Need to pass more data parameters

    }

    private void setData(){
        projectTitle.setText(extras.getString("PROJECT_NAME"));
        projectDescription.setText(extras.getString("DESCRIPTION"));
        // set description and image
    }
}