package com.example.aenrishi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private List<Questions> questions;
    private Context context;

    public QuestionAdapter(Context context, List<Questions> questions) {
        this.context = context;
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Questions currentQuestion = questions.get(position);
        holder.tvQuestion.setText(currentQuestion.getQuestion());
        holder.rbChoiceA.setText(currentQuestion.getChoixA());
        holder.rbChoiceB.setText(currentQuestion.getChoixB());
        holder.rbChoiceC.setText(currentQuestion.getChoixC());
        holder.rbChoiceD.setText(currentQuestion.getChoixD());

        // IMPORTANT : Supprimez tout ancien OnCheckedChangeListener pour éviter des comportements inattendus
        holder.rgChoices.setOnCheckedChangeListener(null);

        // Mettez à jour l'état actuel du RadioGroup en fonction de la réponse sélectionnée de l'utilisateur
        if (currentQuestion.getUserAnswer() != null) {
            if (holder.rbChoiceA.getText().toString().equals(currentQuestion.getUserAnswer())) {
                holder.rgChoices.check(holder.rbChoiceA.getId());
            } else if (holder.rbChoiceB.getText().toString().equals(currentQuestion.getUserAnswer())) {
                holder.rgChoices.check(holder.rbChoiceB.getId());
            } else if (holder.rbChoiceC.getText().toString().equals(currentQuestion.getUserAnswer())) {
                holder.rgChoices.check(holder.rbChoiceC.getId());
            } else if (holder.rbChoiceD.getText().toString().equals(currentQuestion.getUserAnswer())) {
                holder.rgChoices.check(holder.rbChoiceD.getId());
            } else {
                holder.rgChoices.clearCheck(); // Si aucune des options ne correspond, décochez toutes les options
            }
        } else {
            holder.rgChoices.clearCheck(); // Si l'utilisateur n'a pas encore choisi de réponse, décochez toutes les options
        }

        // Écoutez les changements sur le RadioGroup
        holder.rgChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = group.findViewById(checkedId);
                String userChoice = selectedButton.getText().toString();
                currentQuestion.setUserAnswer(userChoice);
            }
        });
    }






    @Override
    public int getItemCount() {
        return questions.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion;
        RadioGroup rgChoices;
        RadioButton rbChoiceA, rbChoiceB, rbChoiceC, rbChoiceD;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tv_question_example);
            rgChoices = itemView.findViewById(R.id.rg_choices);
            rbChoiceA = itemView.findViewById(R.id.rb_answer_example_1);
            rbChoiceB = itemView.findViewById(R.id.rb_answer_example_2);
            rbChoiceC = itemView.findViewById(R.id.rb_answer_example_3);
            rbChoiceD = itemView.findViewById(R.id.rb_answer_example_4);
        }
    }
}
