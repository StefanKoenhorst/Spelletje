package com.example.android.spelletje.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.spelletje.data.Contract.spelEntry;

public class databaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "spelers.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CREATE_SPELER=
            "CREATE TABLE " + spelEntry.TABLE_NAME + " (" +
                    spelEntry._ID + " INTEGER PRIMARY KEY, " +
                    spelEntry.COLUMN_NAME + " TEXT, " +
                    spelEntry.COLUMN_RANK + " TEXT " +
                    ")";

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_SPELER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + spelEntry.TABLE_NAME);
        onCreate(db);
    }
}
