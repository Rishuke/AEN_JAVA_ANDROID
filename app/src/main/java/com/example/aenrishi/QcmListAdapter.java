package com.example.aenrishi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QcmListAdapter extends RecyclerView.Adapter<QcmListAdapter.ViewHolder> {

    private List<Qcm> qcmList;
    private Context context;

    public QcmListAdapter(Context context, List<Qcm> qcmList) {
        this.context = context;
        this.qcmList = qcmList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_qcm, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Qcm qcm = qcmList.get(position);
        holder.tvQcmTitle.setText(qcm.getTitre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Créez un Intent pour démarrer la nouvelle activité
                Intent intent = new Intent(context, QcmDetailActivity.class);
                // Transfert des données
                intent.putExtra("qcmTitre", qcm.getTitre());
                intent.putExtra("qcmid", qcm.getId());// Supposons que Qcm ait une méthode getId()
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return qcmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvQcmTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQcmTitle = itemView.findViewById(R.id.tv_qcm_title);
        }
    }
}
