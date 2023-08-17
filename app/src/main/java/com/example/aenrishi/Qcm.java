package com.example.aenrishi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "quiz",
        foreignKeys = @ForeignKey(
                entity = FormationEntity.class,
                parentColumns = "id",
                childColumns = "formation_id"
        ),
        indices = @Index("formation_id")
)
public class Qcm
{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "titre")
    private String titre;

    @ColumnInfo(name = "score_passage")
    private int score_passage;

    @ColumnInfo(name = "formation_id")
    private int formation_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getScore_passage() {
        return score_passage;
    }

    public void setScore_passage(int score_passage) {
        this.score_passage = score_passage;
    }

    public int getFormation_id() {
        return formation_id;
    }

    public void setFormation_id(int formation_id) {
        this.formation_id = formation_id;
    }
}

