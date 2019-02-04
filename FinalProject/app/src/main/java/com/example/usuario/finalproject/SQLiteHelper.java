package com.example.usuario.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context contexto, String nombre, CursorFactory almacen,int version){
        super(contexto,nombre,almacen,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(BaseDatos.CREATE_TABLE_COCHES);

        db.execSQL(BaseDatos.LLENAR_TABLA_COCHES);

        db.execSQL(BaseDatos.CREATE_TABLE_PEDIDO);

        db.execSQL(BaseDatos.CREATE_TABLE_USUARIO);

        db.execSQL(BaseDatos.LLENAR_TABLA_USUARIO);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int versionAnterior,int versionNueva){
        db.execSQL(BaseDatos.DROP_TABLA_COCHES);
        db.execSQL(BaseDatos.DROP_TABLA_PEDIDO);
        db.execSQL(BaseDatos.DROP_TABLA_USUARIO);

        db.execSQL(BaseDatos.CREATE_TABLE_COCHES);
        db.execSQL(BaseDatos.LLENAR_TABLA_COCHES);
        db.execSQL(BaseDatos.CREATE_TABLE_PEDIDO);
        db.execSQL(BaseDatos.CREATE_TABLE_USUARIO);
        db.execSQL(BaseDatos.LLENAR_TABLA_USUARIO);



    }
}
