package com.example.aenrishi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("authentification/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
