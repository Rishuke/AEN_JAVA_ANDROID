package com.example.aenrishi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QcmDetailActivity extends AppCompatActivity {

    private TextView tvQcmTitle;
    private RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;
    private List<Questions> questionList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm_questions);

        tvQcmTitle = findViewById(R.id.tv_qcm_title);
        recyclerView = findViewById(R.id.recyclerview_questions);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionAdapter = new QuestionAdapter(this, questionList);
        recyclerView.setAdapter(questionAdapter);

        Intent intent = getIntent();
        if (intent != null) {
            String qcmTitle = intent.getStringExtra("qcmTitre");
            if (qcmTitle != null) {
                tvQcmTitle.setText(qcmTitle);
            }
        }

        int quizId = getIntent().getIntExtra("qcmid", -1);
        if(quizId != -1) {
            loadQcmDetails(quizId);
        } else {
            Toast.makeText(this, "Identifiant de quiz non fourni", Toast.LENGTH_SHORT).show();
        }

        Button btnSubmit = findViewById(R.id.btn_submit_answers);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                submitAnswers();
            }
        });
    }

    private void submitAnswers() {
        int correctAnswers = 0;
        for (int i = 0; i < questionList.size(); i++) {
            Questions currentQuestion = questionList.get(i);
            if (this.isUserAnswerCorrect(currentQuestion)) {
                Log.d("SCORE_CALC", "Question " + (i + 1) + " is correct.");
                correctAnswers++;
            } else {
                Log.d("SCORE_CALC", "Question " + (i + 1) + " is incorrect.");
            }

        }

        int score = (correctAnswers * 100) / questionList.size();
        int quizId = getIntent().getIntExtra("qcmid", -1);

        saveResultToServer(score, quizId);
        displayScore(score);
        Toast.makeText(QcmDetailActivity.this, "Votre score est de: " + score + "%", Toast.LENGTH_LONG).show();
    }



    private void displayScore(int score) {
        Intent intent = new Intent(QcmDetailActivity.this, ScoreActivity.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }

    private void saveResultToServer(int score, int quizId) {
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        Log.d("MyApp", "Email: " + email);
        Log.d("MyApp", "Password: " + password);
        Resultat resultat = new Resultat();
        resultat.setMember_id(9);
        resultat.setQuiz_id(quizId);
        resultat.setScore_obtenu(score);
        resultat.setA_obtenu_certificat(score >= 50); // Admettons que 50 est le score minimum pour obtenir un certificat.

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rishi.wicookin.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.postResultat(resultat);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("API_CALL", "Received response with code: " + response.code());
                if (response.isSuccessful()) {
                    Toast.makeText(QcmDetailActivity.this, "Résultat sauvegardé avec succès!", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Log.d("API_ERROR", "Response Error Body: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(QcmDetailActivity.this, "Échec de la sauvegarde du résultat", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("API_CALL", "Failed API call: " + t.getMessage());
                Toast.makeText(QcmDetailActivity.this, "Erreur lors de la sauvegarde: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    public boolean isUserAnswerCorrect(Questions question) {
        return question.isUserAnswerCorrect();
    }

    private void loadQcmDetails(int quizId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rishi.wicookin.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiInterface = retrofit.create(ApiService.class);
        Call<QuestionsResponseWrapper> call = apiInterface.getQuestionsForQuiz(quizId);

        call.enqueue(new Callback<QuestionsResponseWrapper>() {
            @Override
            public void onResponse(Call<QuestionsResponseWrapper> call, Response<QuestionsResponseWrapper> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getQuestions() != null) {
                    questionList.addAll(response.body().getQuestions());
                    questionAdapter.notifyDataSetChanged();

                    if (questionList.isEmpty()) {
                        Toast.makeText(QcmDetailActivity.this, "Pas de questions pour ce QCM", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QcmDetailActivity.this, "Échec du chargement des questions", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<QuestionsResponseWrapper> call, Throwable t) {
                Toast.makeText(QcmDetailActivity.this, "Erreur: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
