package com.example.project3frontend;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {
    // Note this relative url must match the API
    // "posts" is for testing purposes
    @GET("getAllUsers")
    Call<List<User>> getUsers();

    @FormUrlEncoded
    @POST("createNewUser")
    Call<Void> createUser(@Field("email") String email, @Field("username") String username, @Field("password") String password);


}
