package com.example.antrod.a2basedatospersonal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AdminSQLiteHelper admin;
    SQLiteDatabase BaseDeDatos;
    private EditText codigo, descripcion, precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin = new AdminSQLiteHelper(this, "administracion", null,1);
        BaseDeDatos = admin.getWritableDatabase();


        codigo= findViewById(R.id.txt_codigo);
        descripcion= findViewById(R.id.txt_descripcion);
        precio= findViewById(R.id.txt_precio);
    }

    public void Registrar(View view){

        String codigoTexto= codigo.getText().toString();
        String descripcionTexto= descripcion.getText().toString();
        String precioTexto= precio.getText().toString();
        if(!codigoTexto.isEmpty() && !descripcionTexto.isEmpty() && !precioTexto.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigoTexto);
            registro.put("descripcion", descripcionTexto);
            registro.put("precio", precioTexto);

            BaseDeDatos.insert("Clientes", null, registro);

            BaseDeDatos.close();
        }
    }

}
