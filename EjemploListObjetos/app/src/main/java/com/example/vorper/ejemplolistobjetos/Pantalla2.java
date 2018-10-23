package com.example.vorper.ejemplolistobjetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        TextView Titulo = findViewById(R.id.TituloP2);
        TextView Subtitulo = findViewById(R.id.SubtituloP2);
        ImageView Imagen = findViewById(R.id.ivImagenP2);


        Titulo.setText(getIntent().getStringExtra("clave1"));
        Subtitulo.setText(getIntent().getStringExtra("clave2"));
        Imagen.setBackground(getDrawable(getIntent().getIntExtra("clave3",0)));
    }
}
