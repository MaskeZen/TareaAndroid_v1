package com.tisj.tareaandroidv1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maske on 10/09/2016.
 */
public class DbUsuario extends SQLiteOpenHelper {

    public DbUsuario(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST usuario");
        db.execSQL("CREATE TABLE usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)");
    }
}
