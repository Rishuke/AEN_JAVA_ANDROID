package com.example.aenrishi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QcmListAdapter extends RecyclerView.Adapter<ViewHolder> {

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

    }

    @Override
    public int getItemCount() {
        return qcmList.size();
    }
}
