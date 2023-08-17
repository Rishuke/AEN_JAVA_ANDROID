package com.example.aenrishi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class QcmListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewQcmList;
    private QcmListAdapter qcmListAdapter;  // Ceci est un adapter personnalisé que nous devrons créer.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm_list);

        recyclerViewQcmList = findViewById(R.id.recyclerViewQcmList);
        recyclerViewQcmList.setLayoutManager(new LinearLayoutManager(this));

        loadQcmList();
    }

    private void loadQcmList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rishi.wicookin.fr/") // Remplacez par l'URL de base de votre API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiInterface = retrofit.create(ApiService.class);

        // Ici, faites le call pour obtenir la liste des QCM. Par exemple :
        Call<List<Qcm>> call = apiInterface.getQcms();

        call.enqueue(new Callback<List<Qcm>>() {
            @Override
            public void onResponse(Call<List<Qcm>> call, Response<List<Qcm>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    qcmListAdapter = new QcmListAdapter(QcmListActivity.this, response.body());
                    recyclerViewQcmList.setAdapter(qcmListAdapter);
                } else {
                    // Gérez l'échec du chargement des données ici
                    Toast.makeText(QcmListActivity.this, "Échec du chargement des données", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Qcm>> call, Throwable t) {
                // Gérez l'échec de la requête ici
                Toast.makeText(QcmListActivity.this, "Erreur: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });
    }
}