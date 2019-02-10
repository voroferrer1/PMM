package com.example.usuario.finalproject;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Perfil extends AppCompatActivity{
    Bundle bundle;
    SQLiteHelper cliBD;
    Cursor cursor;
    TextView id_pedido;
    TextView modelo;
    TextView precio_total;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);
        savedInstanceState = getIntent().getExtras();
        bundle = savedInstanceState;
        cliBD = new SQLiteHelper(this);
        id_pedido = (TextView) findViewById(R.id.ID);
        modelo = (TextView) findViewById(R.id.coche);
        precio_total = (TextView) findViewById(R.id.precio);
        llenarTabla();
    }
    public void llenarTabla(){
        String[] datosPedido = {bundle.getString("id")};
        String[] columnas = {
                BaseDatos.TABLA_PEDIDO_ID,
                BaseDatos.TABLA_PEDIDO_COCHE_ID,
                BaseDatos.TABLA_PEDIDO_PRECIO_TOTAL};
        String[] columnas_coche = {
                BaseDatos.TABLA_COCHES_ID,
                BaseDatos.TABLA_COCHES_MODELO
        };
        cliBD.open();
        cursor = cliBD.getDatos(BaseDatos.TABLA_PEDIDO_NOMBRE,columnas,"usuario_id = ? ",datosPedido,BaseDatos.TABLA_PEDIDO_ID);
        if(cursor.moveToFirst()){
            id_pedido.setText(cursor.getString(0));
            String[] mod_coches = {cursor.getString(1)};
            precio_total.setText(cursor.getString(2));
            cursor = cliBD.getDatos(BaseDatos.TABLA_COCHES_NOMBRE,columnas_coche,"coches_id = ?",mod_coches,BaseDatos.TABLA_COCHES_ID);
            if(cursor.moveToFirst()){
                modelo.setText(cursor.getString(1));
            }
        }
    }
}
