package com.example.vorper.myalquiler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final Intent intent = getIntent();
        final TextView modelo = (TextView) findViewById(R.id.modelo2);
        final TextView marca = (TextView) findViewById(R.id.marca2);
        final TextView horas = (TextView) findViewById(R.id.horas2);
        final TextView precio = (TextView) findViewById(R.id.precio2);
        final ImageView imagen = (ImageView) findViewById(R.id.imagen2);
        final Button volver = (Button)findViewById(R.id.volver);
        Modelos modelos2 = (Modelos) intent.getSerializableExtra("Objeto");
        modelo.setText(modelos2.getModelo());
        marca.setText(modelos2.getMarca());
        horas.setText(String.valueOf(modelos2.getHoras()));
        precio.setText(String.valueOf(modelos2.getPrecioTotal()));
        imagen.setBackground((getDrawable(modelos2.getView())));
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Pantalla2.this,Pantalla1.class);
                startActivity(intent1);
            }
        });

    }
}
