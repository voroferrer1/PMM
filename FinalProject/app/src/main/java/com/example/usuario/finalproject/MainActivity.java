package com.example.usuario.finalproject;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteHelper cliBD;

    SQLiteDatabase bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliBD = new SQLiteHelper(this,BaseDatos.BASE_DATOS_NOMBRE,null,BaseDatos.DASE_DATOS_VERSION);

        bd = cliBD.getWritableDatabase();


        bd.close();
    }

}
