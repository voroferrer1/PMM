package com.example.usuario.finalproject;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SQLiteHelper cliBD;
    SQLiteDatabase bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliBD = new SQLiteHelper(this);

        cliBD.open();


        cliBD.close();
    }
    public void login(View view){

    }
    public void register(View view){

    }

}
