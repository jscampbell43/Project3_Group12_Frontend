package com.example.project3frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminUsersDetailsActivity extends AppCompatActivity {
    TextView textViewName, textViewPassword;
    EditText editTextU, editTextP;
    Button buttonChange, buttonBack;
    AdminUsers adminUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_details);
        IntentFactory factory = new IntentFactory();

        textViewName = findViewById(R.id.textViewName);
        textViewPassword = findViewById(R.id.textViewPassword);
        editTextU = findViewById(R.id.editTextU);
        editTextU = findViewById(R.id.editTextU);
        buttonChange = findViewById(R.id.buttonChange);
        buttonBack = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            adminUsers = (AdminUsers) intent.getSerializableExtra("data");
            String usernameData = adminUsers.getUsername();
            String passwordData = adminUsers.getPassword();

            textViewName.setText(usernameData);
            textViewPassword.setText(passwordData);
        }
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update user info here
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(AdminUsersDetailsActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });

    }
}
