package com.example.aenrishi;

public class LoginResponse {
    private String token;
    private User user;

    // Ajoutez les getters et les setters si nécessaire

    public static class User {
        private int id;
        private String name;
        private String email;

        // Ajoutez les getters et les setters si nécessaire
    }
}
