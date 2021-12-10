package com.example.project3frontend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AdminApi {
    // Note this relative url must match the API
    // "posts" is for testing purposes
    @GET("getAllUsers")
    Call<List<AdminUsers>> getUsers();

    @FormUrlEncoded
    @POST("createNewUser")
    Call<Void> createUser(@Field("email") String email, @Field("username") String username, @Field("password") String password);

    //set delete call here for deleting a user.

}
