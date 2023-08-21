package com.example.aenrishi;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id; // User's unique ID
    private String email; // User's email for authentication
    private List<Resultat> resultats; // List of results for quizzes the user has taken

    public User(int id, String email) {
        this.id = id;
        this.email = email;
        this.resultats = new ArrayList<>();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }

    // Method to submit answers and save result
    public void submitAnswers(List<Questions> questionList, int quizId) {
        int correctAnswers = 0;

        for (Questions currentQuestion : questionList) {
            if (currentQuestion.isUserAnswerCorrect()) {
                correctAnswers++;
            }
        }

        int score = (correctAnswers * 100) / questionList.size();
        prepareResult(score, quizId);  // This method will save the result to the user's result list
    }

    public Resultat prepareResult(int score, int quizId) {
        Resultat resultat = new Resultat();
        resultat.setMember_id(this.id);
        resultat.setQuiz_id(quizId);
        resultat.setScore_obtenu(score);
        resultat.setA_obtenu_certificat(score >= 50); // Ici, 50 est le score minimum pour obtenir un certificat. Modifiez selon vos besoins.
        return resultat;
    }

    // You can also have a method here to save the result to the server (if needed).
    // private void saveResultToServer(int score, int quizId) {...}
}
