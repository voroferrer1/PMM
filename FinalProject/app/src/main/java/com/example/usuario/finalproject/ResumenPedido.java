package com.example.usuario.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResumenPedido extends AppCompatActivity {
    Bundle bundle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_pedido);
        bundle = getIntent().getExtras();
        final Intent intent = getIntent();
        final TextView modelo = (TextView) findViewById(R.id.modelo2);
        final TextView marca = (TextView) findViewById(R.id.marca2);
        final TextView horas = (TextView) findViewById(R.id.horas2);
        final TextView precio = (TextView) findViewById(R.id.precio2);
        final ImageView imagen = (ImageView) findViewById(R.id.imagen2);
        Modelos modelos2 = (Modelos) intent.getSerializableExtra("Objeto");
        modelo.setText(modelos2.getModelo());
        marca.setText(modelos2.getMarca());
        horas.setText(String.valueOf(modelos2.getHoras()));
        precio.setText(modelos2.getPrecioTotal());
        imagen.setBackground((getDrawable(modelos2.getView())));

    }

    public void volver(View view){
        finish();
    }
}
