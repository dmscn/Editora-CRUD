package br.com.damasceno.editora_crud.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBController {
    private SQLiteDatabase db;
    private OpenDB openDB;

    public DBController(Context context) {
        openDB = new OpenDB(context);
    }

    public String insertData (String title, String author, String publisher) {
        ContentValues values;
        long result;

        db = openDB.getWritableDatabase();
        values = new ContentValues();
        values.put(openDB.TITLE, title);
        values.put(openDB.AUTHOR, author);
        values.put(openDB.PUBLISHER, publisher);

        result = db.insert(openDB.TABLE, null, values);
        db.close();

        if(result > -1) {
            return "Registro Inserido com Sucesso";
        } else {
            return "Erro ao inserir o registro";
        }
    }

    public Cursor loadData() {
        Cursor cursor;
        String[] fields = {OpenDB.ID, OpenDB.TITLE};
        db = openDB.getReadableDatabase();
        cursor = db.query(openDB.TABLE, fields, null, null, null, null, null, null);

        if(cursor!=null) {
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }
}
