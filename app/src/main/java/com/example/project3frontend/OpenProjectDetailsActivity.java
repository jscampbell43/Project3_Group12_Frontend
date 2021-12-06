package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class OpenProjectDetailsActivity extends AppCompatActivity {

    ImageView projectImageView;
    TextView projectTitle, projectDescription, currency, date, budget;

    Bundle extras;
    String title, description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_project_details);

        projectImageView = findViewById(R.id.imageViewProjectImageDetails);
        projectTitle = findViewById(R.id.textViewProjectTitleDetails);
        projectDescription = findViewById(R.id.textViewProjectDescriptionDetails);
        currency = findViewById(R.id.textViewProjectCurrencyDetails);
        date = findViewById(R.id.textViewProjectDatePublishedDetails);
        budget = findViewById(R.id.textViewProjectBudgetDetails);


//        extras.putBoolean("IS_OPEN", projects.get(position).isOpen());
//        extras.putBoolean("ANON", projects.get(position).isAnon());

        getData();
        setData();

    }

    private void getData(){
        extras = getIntent().getExtras();
    }

    private void setData(){
        projectTitle.setText(extras.getString("PROJECT_NAME"));
        projectDescription.setText(extras.getString("DESCRIPTION"));
        Picasso.get().load(extras.getString("URL_STRING")).into(projectImageView);
        currency.setText("Currency: " + extras.getString("CURRENCY"));
        date.setText(extras.getString("DATE_PUBLISHED"));
        budget.setText("Budget: " + Float.toString(extras.getFloat("BUDGET")));
    }
}