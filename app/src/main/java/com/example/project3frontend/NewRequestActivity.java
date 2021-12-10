package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewRequestActivity extends AppCompatActivity {
    // Layout pieces
    private Button buttonBackToProfile;
    private TextView textViewNewRequestWelcome;
    private EditText editTextTitle, editTextBudget, editTextDescription, editTextEmail, editTextProposer, editTextImage;
    private Button buttonPublish;
    private Switch switchAnon;
    private static final String TAG = "NewRequestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);

        // Attach layout
        textViewNewRequestWelcome = findViewById(R.id.textViewNewRequestWelcome);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextBudget = findViewById(R.id.editTextBudget);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextProposer = findViewById(R.id.editTextProposer);
        editTextImage = findViewById(R.id.editTextImage);
        buttonPublish = findViewById(R.id.buttonPublish);
        buttonBackToProfile = findViewById(R.id.buttonBackToProfile);
        switchAnon = findViewById(R.id.switchAnon);

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
                float budget = Float.parseFloat(editTextBudget.getText().toString());
                String description = editTextDescription.getText().toString();
                String email = editTextEmail.getText().toString();
                String proposer = editTextProposer.getText().toString();
                String image = editTextImage.getText().toString();
                //switchAnon.
                Boolean anon = false;
                // Create date object get tostring
                String date = "Today";
                Boolean isClaimed = false;
                String claimedBy = "None";
                String currency = "USD";
                // If title is blank
                if(title.isEmpty()) {
                    Toast.makeText(NewRequestActivity.this, "A title is required", Toast.LENGTH_SHORT).show();
                }else{
                    //TO DO call API to add new request information to database
                    Toast.makeText(NewRequestActivity.this, "The following Info will be added to database here:\n" + title + "\n" + description + "\n" +  image + "\n", Toast.LENGTH_SHORT).show();
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://shrouded-hollows-49087.herokuapp.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ProjectApi projectApi = retrofit.create(ProjectApi.class);

                    Call<Void> call = projectApi.createProject(title, budget, currency, description, email, proposer, image, date, isClaimed, claimedBy, anon);
                    call.enqueue(new Callback<Void>(){
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(!response.isSuccessful()){
                                Toast.makeText(NewRequestActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(NewRequestActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                            System.out.println(t.getMessage());
                        }
                    });
                }
            }
        });
    }
}