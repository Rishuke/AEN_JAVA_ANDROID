package com.example.aenrishi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;


@Entity(tableName = "formation")
@TypeConverters(DateConverter.class)  // Pour la conversion des dates et des heures
public class FormationEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "date_debut")
    private Date date_debut;

    @ColumnInfo(name = "date_fin")
    private Date date_fin;

    @ColumnInfo(name = "heure_debut")
    private Date heure_debut;  // J'ai utilisé Date pour la simplicité. Vous pouvez le modifier si nécessaire.

    @ColumnInfo(name = "heure_fin")
    private Date heure_fin;    // J'ai utilisé Date pour la simplicité. Vous pouvez le modifier si nécessaire.

    @ColumnInfo(name = "prix_formation")
    private float prix_formation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Date getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(Date heure_debut) {
        this.heure_debut = heure_debut;
    }

    public Date getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(Date heure_fin) {
        this.heure_fin = heure_fin;
    }

    public float getPrix_formation() {
        return prix_formation;
    }

    public void setPrix_formation(float prix_formation) {
        this.prix_formation = prix_formation;
    }
}

