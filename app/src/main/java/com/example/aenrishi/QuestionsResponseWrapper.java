package com.example.aenrishi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsResponseWrapper {

    private boolean success;
    @SerializedName("users") // Ajoutez cette annotation ici
    private List<Questions> questions;

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    // Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
}
