package com.example.aenrishi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "resultatsutilisateur",
        foreignKeys = {
                @ForeignKey(
                        entity = Qcm.class,
                        parentColumns = "id",
                        childColumns = "quiz_id"
                ),
                @ForeignKey(
                        entity = User.class,  // Supposons qu'il y ait une classe 'User' pour les membres
                        parentColumns = "id",
                        childColumns = "member_id"
                )
        },
        indices = {
                @Index("quiz_id"),
                @Index("member_id")
        }
)
public class Resultat {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "member_id")
    private int member_id;

    @ColumnInfo(name = "quiz_id")
    private int quiz_id;

    @ColumnInfo(name = "score_obtenu")
    private int score_obtenu;

    @ColumnInfo(name = "a_obtenu_certificat")
    private boolean a_obtenu_certificat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getScore_obtenu() {
        return score_obtenu;
    }

    public void setScore_obtenu(int score_obtenu) {
        this.score_obtenu = score_obtenu;
    }

    public boolean isA_obtenu_certificat() {
        return a_obtenu_certificat;
    }

    public void setA_obtenu_certificat(boolean a_obtenu_certificat) {
        this.a_obtenu_certificat = a_obtenu_certificat;
    }
}
