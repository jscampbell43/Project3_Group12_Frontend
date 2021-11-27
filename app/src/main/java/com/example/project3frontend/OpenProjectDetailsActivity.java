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
        if(getIntent().hasExtra("data")){
            title = getIntent().getStringExtra("data");
            // Need to pass more data parameters
        }
        else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        projectTitle.setText(title);
        // set description and image
    }
}