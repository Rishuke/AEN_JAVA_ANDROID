package com.example.aenrishi;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tvQcmTitle, tvQcmDescription;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        tvQcmTitle = itemView.findViewById(R.id.tv_qcm_title);
        tvQcmDescription = itemView.findViewById(R.id.tv_qcm_description);
    }
}