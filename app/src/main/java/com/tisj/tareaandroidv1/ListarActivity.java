package com.tisj.tareaandroidv1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListarActivity extends AppCompatActivity {

    SQLiteDatabase db;
    TextView listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        listaUsuarios = (TextView)findViewById(R.id.listadoUsr);
        DbUsuario dbUsr = new DbUsuario(this, "usuario", null, 1);
        db = dbUsr.getWritableDatabase();

        Cursor cursor = db.query("usuario", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String texto = cursor.getString(1);
                listaUsuarios.append(" - " + texto + "\n");
            }while (cursor.moveToNext());
        }

    }




}
