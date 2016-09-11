package com.tisj.tareaandroidv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UsuarioActivity extends AppCompatActivity {

    TextView textNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        textNombre = (TextView)findViewById(R.id.nombreUsuario);
        Bundle extras = getIntent().getExtras();
        String nombreUsuario = extras.getString("nombreUsuario");
        textNombre.setText(nombreUsuario);

    }
}
