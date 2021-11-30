package com.example.project3frontend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {
    // Note this relative url must match the API
    @GET("users")
    Call<List<User>> getUsers();
}
