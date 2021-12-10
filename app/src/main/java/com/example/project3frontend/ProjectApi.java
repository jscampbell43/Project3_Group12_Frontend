package com.example.project3frontend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProjectApi {

    @GET("getAllProjects")
    Call<List<Project>> getProjects();

    @FormUrlEncoded
    @POST("createNewProject")
    Call<Void> createProject(@Field("projectName") String projectName,
                             @Field("budget") float budget, @Field("currency") String currency, @Field("description") String description,
                             @Field("email") String email, @Field("proposer") String proposer,
                             @Field("urlString") String urlString, @Field("datePublished") String datePublished,
                             @Field("isClaimed") Boolean isClaimed, @Field("claimedBy") String claimedBy,
                             @Field("anon") Boolean anon);

}
