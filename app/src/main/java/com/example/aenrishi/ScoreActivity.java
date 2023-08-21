package com.example.aenrishi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    private TextView tvScore;
    private TextView tvCertificationStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_actitvity);

        tvScore = findViewById(R.id.tv_score_value);
        tvCertificationStatus = findViewById(R.id.tv_certificate_info);

        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE", 0);

        tvScore.setText("Votre score: " + score + "%");

        if (score >= 70) {
            tvCertificationStatus.setText("Félicitations! Vous avez validé le certificat.");
        } else {
            tvCertificationStatus.setText("Malheureusement, vous n'avez pas validé le certificat. Essayez à nouveau.");
        }
    }
}
