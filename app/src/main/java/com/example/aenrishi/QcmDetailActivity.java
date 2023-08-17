package com.example.aenrishi;



import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QcmDetailActivity extends AppCompatActivity {

    private TextView tvQcmId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm_questions);

        tvQcmId = findViewById(R.id.tv_qcm_title);

        // Récupération de l'ID QCM à partir de l'intention
        String qcmId = getIntent().getStringExtra("qcmId");
        if (qcmId != null) {
            tvQcmId.setText("QCM ID: " + qcmId);
        } else {
            tvQcmId.setText("Erreur: ID QCM manquant");
        }

        // TODO: Récupérez d'autres détails du QCM en utilisant cet ID
        // par exemple, faire une requête API pour obtenir les détails du QCM basé sur l'ID
    }
}