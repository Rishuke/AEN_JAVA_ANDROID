package com.example.aenrishi;

import java.util.List; // Ajout de cet import

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @POST("authentification/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("chapitres")
    Call<ResponseWrapper> getQcms();



    @GET("questions/{quizid}")
    Call<QuestionsResponseWrapper> getQuestionsForQuiz(@Path("quizid") int quizId);
}
