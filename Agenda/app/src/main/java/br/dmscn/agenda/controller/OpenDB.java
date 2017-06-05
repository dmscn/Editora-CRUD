package br.dmscn.agenda.controller;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "agenda.db";
    public static final String TABLE = "contato";
    public static final String ID = ""

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
