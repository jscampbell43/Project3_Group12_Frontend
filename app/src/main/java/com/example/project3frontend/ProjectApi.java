package com.example.project3frontend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProjectApi {

    @GET("getAllProjects")
    Call<List<Project>> getProjects();
}
