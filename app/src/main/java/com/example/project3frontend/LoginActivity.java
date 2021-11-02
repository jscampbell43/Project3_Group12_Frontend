package com.example.project3frontend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    // Layout pieces
    private TextView textViewLoginWelcome;
    private EditText editTextLoginUsername;
    private EditText editTextLoginPassword;
    private Button buttonLogin;
    private static final String TAG = "LoginActivity";
    private Button mCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Attach layout
        textViewLoginWelcome = findViewById(R.id.textViewLoginWelcome);
        editTextLoginUsername = findViewById(R.id.editTextLoginUsername);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        mCreateAccount = findViewById(R.id.buttonToRegisterFromLogin);

        // Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextLoginUsername.getText().toString();
                String password = editTextLoginPassword.getText().toString();

                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }else{
                    //call API to get instance of database and access the users information
                    //call api to verify the right user with the database by passing in username and password
                    //check users information with validate(user)
                    //if the right user exist then pass in their id or email information to next page.
                    //if user does not exist then display error message.
                    //Use intent factory to proceed to next page
                    //Use boolean statements to verify true or false for validate user and for testing purposes.
                    Intent intent = factory.getIntent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        //Moves user to make a new account
        mCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    //Validate Username and Password Boolean Here:
//    public Boolean validate() {
//
//    }

}
