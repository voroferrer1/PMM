package com.example.usuario.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ResumenPedido extends AppCompatActivity {
    Bundle bundle;
    SQLiteHelper cliBD;
    Modelos modelos2;
    TextView modelo;
    TextView marca;
    TextView horas;
    TextView precio;
    TextView gps;
    TextView radio;
    TextView aire;
    Cursor cursor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_pedido);
        cliBD = new SQLiteHelper(this);
        bundle = getIntent().getExtras();
        final Intent intent = getIntent();
        modelo = (TextView) findViewById(R.id.modelo2);
        marca = (TextView) findViewById(R.id.marca2);
        horas = (TextView) findViewById(R.id.horas2);
        precio = (TextView) findViewById(R.id.precio2);
        gps = (TextView) findViewById(R.id.GPS);
        radio = (TextView) findViewById(R.id.radio2);
        aire = (TextView) findViewById(R.id.aire2);
        final ImageView imagen = (ImageView) findViewById(R.id.imagen2);
        modelos2 = (Modelos) intent.getSerializableExtra("Objeto");
        modelo.setText(modelos2.getModelo());
        marca.setText(modelos2.getMarca());
        horas.setText(String.valueOf(modelos2.getHoras()));
        precio.setText(modelos2.getPrecioTotal()+"€");
        imagen.setBackground((getDrawable(modelos2.getView())));
        if(modelos2.getGPS()){
            gps.setText("Si");
        }
        if(modelos2.getRadioDVD()){
            radio.setText("Si");
        }
        if (modelos2.getAire()){
            aire.setText("Si");
        }
    }

    public void volver(View view){
        finish();
    }
    public void confirmar(View view){
        cliBD.open();
        String usuario_id = bundle.getString("id");
        String[] argument = {modelos2.getModelo()};
        String[] columnas_coche = {BaseDatos.TABLA_COCHES_ID};
        cursor = cliBD.getDatos(BaseDatos.TABLA_COCHES_NOMBRE,columnas_coche,"modelo = ?",argument,BaseDatos.TABLA_COCHES_ID);
        cursor.moveToFirst();
        String coche_id = cursor.getString(0);
        String[][] insercion = {{BaseDatos.TABLA_PEDIDO_COCHE_ID,coche_id},
                {BaseDatos.TABLA_PEDIDO_PRECIO_TOTAL,modelos2.getPrecioTotal()},
                {BaseDatos.TABLA_PEDIDO_USUARIO_ID,usuario_id},
                {BaseDatos.TABLA_PEDIDO_HORAS,Float.toString(modelos2.getHoras())},
                {BaseDatos.TABLA_PEDIDO_RADIO,Boolean.toString(modelos2.getRadioDVD())},
                {BaseDatos.TABLA_PEDIDO_GPS,Boolean.toString(modelos2.getGPS())},
                {BaseDatos.TABLA_PEDIDO_AIRE,Boolean.toString(modelos2.getAire())}};
        cliBD.insertarUsuario(BaseDatos.TABLA_PEDIDO_NOMBRE,insercion);
        cliBD.close();
        Toast.makeText(ResumenPedido.this,"Pedido Realizado",Toast.LENGTH_LONG).show();
        finish();
    }
}
