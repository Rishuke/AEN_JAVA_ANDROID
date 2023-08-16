package com.example.aenrishi;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class QcmListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm_list);  // Assurez-vous d'avoir un layout XML nommé activity_qcm_list

        // Initialisez vos vues et vos logiques spécifiques pour cette activité ici.
        // Par exemple :
        // TextView textView = findViewById(R.id.textView);
        // textView.setText("Voici la liste des QCMs");
    }
}
