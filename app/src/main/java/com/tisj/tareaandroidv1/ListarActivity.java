package com.tisj.tareaandroidv1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ListView listaUsuarios;
    ArrayAdapter<String> adaptador;
    List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        listaUsuarios = (ListView)findViewById(R.id.listUsuarios);
        DbUsuario dbUsr = new DbUsuario(this, "usuario", null, 1);
        db = dbUsr.getWritableDatabase();

        lista = new ArrayList<>();

        Cursor cursor = db.query("usuario", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String texto = cursor.getString(1);
                lista.add(" - " + texto);
            }while (cursor.moveToNext());
        }

        adaptador = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista_usuario, lista);
        listaUsuarios.setAdapter(adaptador);

        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                String nombre = lista.get(posicion);
                Intent intento = new Intent(getApplicationContext(), UsuarioActivity.class);
                intento.putExtra("nombreUsuario", nombre);
                startActivity(intento);
            }
        });

    }

}
