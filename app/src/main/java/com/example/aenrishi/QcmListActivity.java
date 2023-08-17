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
    private QcmListAdapter qcmListAdapter;

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
                .baseUrl("https://rishi.wicookin.fr/") // L'URL de base de votre API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiInterface = retrofit.create(ApiService.class);

        Call<ResponseWrapper> call = apiInterface.getQcms();

        call.enqueue(new Callback<ResponseWrapper>() {
            @Override
            public void onResponse(Call<ResponseWrapper> call, Response<ResponseWrapper> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Qcm> qcmList = response.body().getUsers();
                    qcmListAdapter = new QcmListAdapter(QcmListActivity.this, qcmList);
                    recyclerViewQcmList.setAdapter(qcmListAdapter);
                } else {
                    Toast.makeText(QcmListActivity.this, "Échec du chargement des données", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseWrapper> call, Throwable t) {
                Toast.makeText(QcmListActivity.this, "Erreur: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });
    }
}
