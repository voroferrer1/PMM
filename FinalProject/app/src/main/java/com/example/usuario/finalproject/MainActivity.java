package com.example.usuario.finalproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteHelper cliBD = new SQLiteHelper(this,BaseDatos.BASE_DATOS_NOMBRE,null,1);

        SQLiteDatabase bd = cliBD.getWritableDatabase();
        bd.close();
    }
}
