package br.com.damasceno.editora_crud.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Path;

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

        if(result>-1) {
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

    public Cursor laodDataById(int id) {
        Cursor cursor;
        String[] fields = {OpenDB.ID, OpenDB.TITLE, OpenDB.AUTHOR, OpenDB.PUBLISHER};
        String where = OpenDB.ID + "=" + id;
        db = openDB.getReadableDatabase();
        cursor = db.query(OpenDB.TABLE, fields, where, null, null, null, null, null);

        if(cursor!=null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void updateRegister(int id, String title, String author, String publisher) {
        ContentValues values;
        String where;

        db = openDB.getWritableDatabase();

        where = OpenDB.ID + "=" + id;

        values = new ContentValues();
        values.put(OpenDB.TITLE, title);
        values.put(OpenDB.AUTHOR, author);
        values.put(OpenDB.PUBLISHER, publisher);

        db.update(OpenDB.TABLE, values, where, null);
        db.close();
    }

    public void deleteRegister(int id) {
        String where = OpenDB.ID + "=" + id;

        db = openDB.getReadableDatabase();
        db.delete(OpenDB.TABLE, where, null);
        db.close();
    }
}
