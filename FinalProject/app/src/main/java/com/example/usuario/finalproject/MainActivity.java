package com.example.usuario.finalproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteHelper cliBD;
    EditText usuario;
    EditText contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliBD = new SQLiteHelper(this);
        usuario = findViewById(R.id.et_usuario);
        contraseña = findViewById(R.id.et_contraseña);

    }
    public void login(View view){
        String nombreUsuarioLogin = usuario.getText().toString();
        String contraseñaUsuarioLogin = contraseña.getText().toString();
        Cursor cursorLogin;
        if(nombreUsuarioLogin.equals("") && contraseñaUsuarioLogin.equals("")){
            Toast.makeText(MainActivity.this,"Introduce Usuario y Contraseña",Toast.LENGTH_LONG).show();
        }else {
            if (nombreUsuarioLogin.equals("")) {
                Toast.makeText(MainActivity.this, "Introduce Usuario", Toast.LENGTH_LONG).show();
            }
            if (contraseñaUsuarioLogin.equals("")) {
                Toast.makeText(MainActivity.this, "Introduce Contraseña", Toast.LENGTH_LONG).show();
            } else {
                String[] datosUsuario = {nombreUsuarioLogin,contraseñaUsuarioLogin};
                String[] columnas = {
                        BaseDatos.TABLA_USUARIO_ID,
                        BaseDatos.TABLA_USUARIO_USER};
                cliBD.open();
                cursorLogin= cliBD.getDatos(BaseDatos.TABLA_USUARIO_NOMBRE,columnas,"user = ? AND password = ?",datosUsuario,BaseDatos.TABLA_USUARIO_ID);
                if (cursorLogin.moveToFirst()) {
                    String loginUsuario = cursorLogin.getString(0);
                    String loginContraseña = cursorLogin.getString(1);
                    setContentView(R.layout.login);
                }else{
                    Toast.makeText(MainActivity.this,"Usuario y Contraseña incorrectos",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    public void register(View view){
        String nombreUsuario = usuario.getText().toString();
        String contraseñaUsuario = contraseña.getText().toString();
        Cursor cursor;
        if(nombreUsuario.equals("") && contraseñaUsuario.equals("")){
            Toast.makeText(MainActivity.this,"Introduce Usuario y Contraseña",Toast.LENGTH_LONG).show();
        }else{
            if(nombreUsuario.equals("")){
                Toast.makeText(MainActivity.this,"Introduce Usuario",Toast.LENGTH_LONG).show();
            }
            if(contraseñaUsuario.equals("")){
                Toast.makeText(MainActivity.this,"Introduce Contraseña",Toast.LENGTH_LONG).show();
            }else{
                String[] datosUsuario = {nombreUsuario};
                String[] columnas = {
                        BaseDatos.TABLA_USUARIO_ID,
                        BaseDatos.TABLA_USUARIO_USER,
                };
                cliBD.open();
                cursor= cliBD.getDatos(BaseDatos.TABLA_USUARIO_NOMBRE,columnas,"user = ?",datosUsuario,BaseDatos.TABLA_USUARIO_ID);
                if (cursor.moveToFirst()) {
                    String aRegistrar = cursor.getString(1);
                    if(aRegistrar.equals(nombreUsuario)){
                        Toast.makeText(MainActivity.this,"Este Usuario ya existe.\nPrueba de nuevo.",Toast.LENGTH_LONG).show();
                    }
                }else{
                    String[][] insercion = {{"user",nombreUsuario},{"password",contraseñaUsuario}};
                    cliBD.insertarUsuario(BaseDatos.TABLA_USUARIO_NOMBRE,insercion);
                    Toast.makeText(MainActivity.this,"Usuario creado.",Toast.LENGTH_LONG).show();
                }
                if (!cursor.isClosed()){
                    cursor.close();
                }
                cliBD.close();
            }
        }
    }

}
