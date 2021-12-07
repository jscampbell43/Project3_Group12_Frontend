package com.example.project3frontend;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private List<User> users;
    private Boolean check = true;
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

                // If username or password is blank
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
                            for (User user : users) {
                                if(user.getEmail().equals(email)){
                                    Toast.makeText(RegisterActivity.this, "Username already taken, try something different", Toast.LENGTH_LONG).show();
                                    check = false;
                                    break;
                                }
                            }
                            if (check == true){
                                //Insert new user data into database here
                                Toast.makeText(RegisterActivity.this, "User Successfully Created", Toast.LENGTH_LONG).show();
                                Intent intent = factory.getIntent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }else{
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

    private Boolean validateInput(String user){
//        if(user.getUser_first_name().isEmpty() || usersEntity.getUser_last_name().isEmpty() || usersEntity.getUser_name().isEmpty() || usersEntity.getUser_password().isEmpty()){
//            return false;
//        }else{
//            return true;
//        }
        return true;
    }
}