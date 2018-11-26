package com.example.vorper.bicididactico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class SoloBici extends AppCompatActivity{
    private Button bAcercaDe;
    private Button bJuego;
    private Button bSalir;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_bici);

        //Boton y listener para la pantalla de Juego

        bJuego = (Button) findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                lanzarJuego();
            }
        });
        bAcercaDe = (Button) findViewById(R.id.Boton03);
        bAcercaDe.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAcercaDe();
            }
        });
        bSalir = (Button) findViewById(R.id.Boton04);
        bSalir.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarSalir();
            }
        });
    }
    public void lanzarJuego(){
        Intent i = new Intent(this,Juego.class);
        startActivity(i);
    }
    public void lanzarAcercaDe(){
        Intent i = new Intent(this,AcercaDe.class);
    }
    public void lanzarSalir(){
        finish();
    }
}
