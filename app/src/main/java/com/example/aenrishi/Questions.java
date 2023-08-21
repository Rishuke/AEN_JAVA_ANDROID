package com.example.aenrishi;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "questions",
        foreignKeys = @ForeignKey(
                entity = Qcm.class,
                parentColumns = "id",
                childColumns = "quiz_id",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.SET_NULL
        ),
        indices = @Index("quiz_id")
)
public class Questions {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "question")
    private String question;

    @ColumnInfo(name = "choixA")
    private String choixA;

    @ColumnInfo(name = "choixB")
    private String choixB;

    @ColumnInfo(name = "choixC")
    private String choixC;

    @ColumnInfo(name = "choixD")
    private String choixD;

    @ColumnInfo(name = "reponse")
    private String reponse;

    @ColumnInfo(name = "quiz_id")
    private Integer quiz_id; // C'est Integer car il peut être null (on delete set null)

    private String userAnswer;

    // Getters et Setters pour tous les champs...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoixA() {
        return choixA;
    }

    public void setChoixA(String choixA) {
        this.choixA = choixA;
    }

    public String getChoixB() {
        return choixB;
    }

    public void setChoixB(String choixB) {
        this.choixB = choixB;
    }

    public String getChoixC() {
        return choixC;
    }

    public void setChoixC(String choixC) {
        this.choixC = choixC;
    }

    public String getChoixD() {
        return choixD;
    }

    public void setChoixD(String choixD) {
        this.choixD = choixD;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Integer getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Integer quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean isUserAnswerCorrect() {
        Log.d("ANSWER_CHECK", "User Answer: " + userAnswer + ", Correct Answer: " + this.reponse);
        return userAnswer.equals(this.reponse);
    }

}
