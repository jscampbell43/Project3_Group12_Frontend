package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenProjectsActivity extends AppCompatActivity implements ProjectListAdapter.OnProjectClickListener{

    // Layout pieces
    private Button buttonBackToProfile;
    private TextView textViewOpenProjectsWelcome;
    private EditText editTextSearchProject;
    private Button buttonSearchProject;
    String data[];
    RecyclerView rvProjectList;
    private static final String TAG = "NewRequestActivity";
    List<Project> projects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_projects);

        // Attach layout
        textViewOpenProjectsWelcome = findViewById(R.id.textViewOpenProjectsWelcome);
        editTextSearchProject = findViewById(R.id.editTextSearchProject);
        buttonSearchProject = findViewById(R.id.buttonSearchProject);
        buttonBackToProfile = findViewById(R.id.buttonBackToProfile);
        rvProjectList = findViewById(R.id.rvProjects);

        // call API to get instance of database and access list of all published projects
        data = new String[]{"test_1", "test_2", "test_3"};
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shrouded-hollows-49087.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProjectApi projectApi = retrofit.create(ProjectApi.class);

        Call<List<Project>> call = projectApi.getProjects();

        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(OpenProjectsActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                projects = response.body();
                ProjectListAdapter projectListAdapter = new ProjectListAdapter(OpenProjectsActivity.this, projects, OpenProjectsActivity.this);
                rvProjectList.setAdapter(projectListAdapter);
                rvProjectList.setLayoutManager(new LinearLayoutManager(OpenProjectsActivity.this));
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Toast.makeText(OpenProjectsActivity.this, "Call Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        buttonBackToProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(OpenProjectsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonSearchProject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String searchKeyword = editTextSearchProject.getText().toString();

                if(searchKeyword.isEmpty()){
                    Toast.makeText(OpenProjectsActivity.this, "No search term entered", Toast.LENGTH_SHORT).show();
                    // call API to and access list of all published projects
                }else{
                    Toast.makeText(OpenProjectsActivity.this, "Search term: " + searchKeyword, Toast.LENGTH_SHORT).show();
                    //call API and access the project information specific to keyword
                    //get full list of published projects
                    // Display list
                }
            }
        });

    }

    @Override
    public void onProjectClick(int position) {
        String s = data[position];
        Intent intent = new Intent(getApplicationContext(), OpenProjectDetailsActivity.class);
        intent.putExtra("data", data[position]);
        startActivity(intent);
    }
}