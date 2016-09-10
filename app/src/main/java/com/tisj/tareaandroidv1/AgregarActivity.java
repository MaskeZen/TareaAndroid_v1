package com.tisj.tareaandroidv1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAgregar;
    EditText editNombre;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        btnAgregar = (Button)findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);

        editNombre = (EditText)findViewById(R.id.editNombre);

        DbUsuario dbUsr = new DbUsuario(this, "usuario", null, 1);
        db = dbUsr.getWritableDatabase();
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnAgregar:

                ContentValues cv = new ContentValues();
                cv.put("nombre", editNombre.getText().toString());
                db.insert("usuario", null, cv);

                editNombre.setText("");
                Toast.makeText(this, "Se ha agregado el usuario con éxito!", Toast.LENGTH_SHORT).show();

                break;
        }

    }
}
