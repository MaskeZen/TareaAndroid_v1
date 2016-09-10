package com.tisj.tareaandroidv1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCrear;
    Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = (Button)findViewById(R.id.btnAgregar);
        btnCrear.setOnClickListener(this);

        btnListar = (Button)findViewById(R.id.btnListar);
        btnListar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intento;
        switch (view.getId()){
            case R.id.btnAgregar:
                intento = new Intent(this.getApplicationContext(), AgregarActivity.class);
                startActivity(intento);
                break;
            case R.id.btnListar:
                intento = new Intent(this.getApplicationContext(), ListarActivity.class);
                startActivity(intento);
                break;
            default:

                break;

        }

    }
}
