package com.example.aenrishi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        // Création de l'instance Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rishi.wicookin.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Création de l'instance de l'interface ApiService
        apiService = retrofit.create(ApiService.class);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    } // fin de la méthode onCreate()

    private void performLogin() {
        String email = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Création de l'objet de demande de connexion
        LoginRequest loginRequest = new LoginRequest(email, password);

        // Appel de la méthode d'API de connexion
        Call<LoginResponse> call = apiService.login(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    // Connexion réussie
                    LoginResponse loginResponse = response.body();
                    // ...
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    // Échec de la connexion
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Échec de la connexion. Veuillez vérifier vos informations d'identification.", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // Échec de la requête
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Échec de la connexion. Veuillez réessayer plus tard.", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
} // fin de la classe MainActivity
