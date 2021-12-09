package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    // Layout pieces
    private Button buttonBackToLogin;
    private TextView textViewRegisterWelcome;
    private EditText editTextRegisterEmail;
    private EditText editTextRegisterPassword;
    private EditText editTextRegisterPasswordAgain;
    private EditText editTextRegisterUsername;
    private Button buttonRegister;
    private static final String TAG = "RegisterActivity";
    private boolean check = true;
    private List<User> users;
//    private DatabaseReference mDatabase;
//    mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Attach layout
        buttonBackToLogin = findViewById(R.id.buttonBackToLogin);
        textViewRegisterWelcome = findViewById(R.id.textViewRegisterWelcome);
        editTextRegisterEmail = findViewById(R.id.editTextRegisterEmail);
        editTextRegisterPassword = findViewById(R.id.editTextRegisterPassword);
        editTextRegisterPasswordAgain = findViewById(R.id.editTextRegisterPasswordAgain);
        editTextRegisterUsername = findViewById(R.id.editTextRegisterUsername);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextRegisterEmail.getText().toString();
                String username = editTextRegisterUsername.getText().toString();
                String password = editTextRegisterPassword.getText().toString();
                String passwordAgain = editTextRegisterPasswordAgain.getText().toString();
//                 If username or password is blank
                if(email.isEmpty() || username.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                // If passwords do not match
                } else if(!password.equals(passwordAgain)){
                    Toast.makeText(RegisterActivity.this, "Passwords must match", Toast.LENGTH_SHORT).show();
                // TO DO else if check for if Username already exists using API call
                }else{
                    //TO DO call API to add user information to database
                    //Use intent factory to proceed to next page
                    //Use boolean statements to verify true or false for validate user and for testing purposes.
                    // Instance of Retrofit
                    // Note Change .baseUrl to our heroku hosted API
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://shrouded-hollows-49087.herokuapp.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    UserApi userApi = retrofit.create(UserApi.class);
                    Call<List<User>> call = userApi.getUsers();
                    call.enqueue(new Callback<List<User>>(){
                        @Override
                        public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                            if(!response.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                                return;
                            }
                            users = response.body();
                            for (User p : users) {
                                Log.d(TAG, p.getEmail());
                                if(p.getEmail().equals(email) || p.getUsername().equals(username)){
                                    check = false;
                                    System.out.println("CHECKK: " + check);
                                    break;
                                }
                            }
                            System.out.println(check);
                            if (check == true){
                                //Insert new user data into database here
                                postData(email, username, password);
                                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = factory.getIntent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Username already taken, try something different", Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        @Override
                        public void onFailure(Call<List<User>> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });

        buttonBackToLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void postData(String email, String username, String password) {
        // Instance of Retrofit
        // Note Change .baseUrl to our heroku hosted API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shrouded-hollows-49087.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi userApi = retrofit.create(UserApi.class);

        Call<Void> call = userApi.createUser(email, username, password);
        call.enqueue(new Callback<Void>(){
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println(t.getMessage());
            }
        });

    }
}