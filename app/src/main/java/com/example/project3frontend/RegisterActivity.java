package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    // Layout pieces
    private TextView textViewRegisterWelcome;
    private EditText editTextRegisterEmail;
    private EditText editTextRegisterPassword;
    private EditText editTextRegisterPasswordAgain;
    private Button buttonRegister;
    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Attach layout
        textViewRegisterWelcome = findViewById(R.id.textViewRegisterWelcome);
        editTextRegisterEmail = findViewById(R.id.editTextRegisterEmail);
        editTextRegisterPassword = findViewById(R.id.editTextRegisterPassword);
        editTextRegisterPasswordAgain = findViewById(R.id.editTextRegisterPasswordAgain);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextRegisterEmail.getText().toString();
                String password = editTextRegisterPassword.getText().toString();
                String passwordAgain = editTextRegisterPasswordAgain.getText().toString();
                // If username or password is blank
                if(email.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                // If passwords do not match
                } else if(!password.equals(passwordAgain)){
                    Toast.makeText(RegisterActivity.this, "Passwords must match", Toast.LENGTH_SHORT).show();
                // TO DO else if check for if Username already exists using API call
                }else{
                    //TO DO call API to add user information to database
                    //Use intent factory to proceed to next page
                    //Use boolean statements to verify true or false for validate user and for testing purposes.
                    Intent intent = factory.getIntent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}