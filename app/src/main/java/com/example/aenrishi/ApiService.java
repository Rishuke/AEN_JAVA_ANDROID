package com.example.aenrishi;

import java.util.List; // Ajout de cet import

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;

public interface ApiService {
    @POST("authentification/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("chapitres") // Correction des guillemets ici
    Call<List<Qcm>> getQcms();
}
