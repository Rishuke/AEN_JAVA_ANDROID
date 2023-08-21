package com.example.aenrishi;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "aen_rishi.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Aucune action nécessaire, la base de données et la table existent déjà
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aucune action nécessaire, la base de données et la table existent déjà
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Membre WHERE email = ? AND password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }

    public int getMemberId(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id_member FROM Membre WHERE email = ? AND password = ?", new String[]{email, password});
        if (cursor.moveToFirst()) {
            int memberId = cursor.getInt(0);
            cursor.close();
            return memberId;
        } else {
            cursor.close();
            return -1;
        }
    }
    /*
    public List<Item> getItems(int memberId, int limit) {
        List<Item> items = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT f.image_formation, f.title_formation, f.description_formation " +
                "FROM Formation f " +
                "INNER JOIN Progression p ON f.id_formation = p.id_formation " +
                "WHERE p.id_member = ? " +
                "GROUP BY f.image_formation " +
                "LIMIT ?";

        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(memberId), String.valueOf(limit)});

        while(cursor.moveToNext()) {
            Item item = new Item(cursor.getString(0), cursor.getString(1), cursor.getString(2), "En cours");
            items.add(item);
        }
        cursor.close();

        return items;
    }


    public List<RecommendedList> getRecommendedItems(int memberId, int limit) {
        List<RecommendedList> recommendedItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Requête pour récupérer les cours recommandés aléatoires qui ne sont pas suivis par l'utilisateur
        String query = "SELECT f.image_formation, f.title_formation, f.description_formation, f.difficulty_level, f.duration " +
                "FROM Formation f " +
                "WHERE f.id_formation NOT IN " +
                "(SELECT p.id_formation FROM Progression p WHERE p.id_member = ?) " +
                "ORDER BY RANDOM() " +
                "LIMIT ?";

        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(memberId), String.valueOf(limit)});

        while (cursor.moveToNext()) {
            String image = cursor.getString(0);
            String title = cursor.getString(1);
            String description = cursor.getString(2);
            String difficulty = cursor.getString(3);
            String duration = cursor.getString(4);

            recommendedItems.add(new RecommendedList(image, title, description, difficulty, duration));
        }
        cursor.close();

        return recommendedItems;
    }

    public List<FinishedList> getFinishedItems(int memberId, int limit) {
        List<FinishedList> finishedItems = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT f.image_formation, f.title_formation, f.description_formation " +
                "FROM Formation f " +
                "INNER JOIN Progression p ON f.id_formation = p.id_formation " +
                "WHERE p.id_member = ? AND p.percentage_progress = 100 " +
                "LIMIT ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(memberId), String.valueOf(limit)});

        if (cursor.moveToFirst()) {
            do {
                String image = cursor.getString(cursor.getColumnIndex("image_formation"));
                String title = cursor.getString(cursor.getColumnIndex("title_formation"));
                String description = cursor.getString(cursor.getColumnIndex("description_formation"));

                finishedItems.add(new FinishedList(image, title, description));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return finishedItems;
    }
    */


}