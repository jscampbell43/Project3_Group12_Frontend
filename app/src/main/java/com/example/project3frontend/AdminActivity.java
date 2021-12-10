package com.example.project3frontend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdminActivity extends AppCompatActivity implements AdminAdapter.ClickedItem{
    RecyclerView recyclerView;
    AdminAdapter adminAdapter;
    private List<AdminUsers> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adminAdapter = new AdminAdapter(this::ClickedUser);
        getAllUsers();
    }

    public void getAllUsers(){
        // Instance of Retrofit
        // Note Change .baseUrl to our heroku hosted API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shrouded-hollows-49087.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AdminApi userApi = retrofit.create(AdminApi.class);
        Call<List<AdminUsers>> call = userApi.getUsers();
        call.enqueue(new Callback<List<AdminUsers>>(){
            @Override
            public void onResponse(Call<List<AdminUsers>> call, Response<List<AdminUsers>> response) {
                if(response.isSuccessful()){
                    List<AdminUsers> adminUsers = response.body();
                    //remove admin account in adminUsers if possible
                    adminAdapter.setData(adminUsers);
                    recyclerView.setAdapter(adminAdapter);
                }
                users = response.body();
            }

            @Override
            public void onFailure(Call<List<AdminUsers>> call, Throwable t) {
                Toast.makeText(AdminActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ClickedUser(AdminUsers adminUsers) {
        startActivity(new Intent(this, AdminUsersDetailsActivity.class).putExtra("data", adminUsers));
    }
    //add another void ClickesTrash and delete user here with api?


}
